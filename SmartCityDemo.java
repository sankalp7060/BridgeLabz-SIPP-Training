import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// ===================== Core contracts =====================

// 3) Default methods in interfaces
interface TransportService {
    String getName();
    String getType();              // e.g., BUS, METRO, TAXI, AMBULANCE
    List<Schedule> getLiveSchedules(); // live departures (demo data)
    FareCalculator getFareCalculator();

    default void printServiceDetails() {
        System.out.println(getType() + " - " + getName() + " (schedules: " + getLiveSchedules().size() + ")");
    }

    // convenient default to push schedules to dashboard
    default void pushToDashboard(Consumer<Schedule> dashboardSink) {
        getLiveSchedules().forEach(dashboardSink);
    }
}

// 4) Static methods in interfaces
interface GeoUtils {
    static double calculateDistance(Gps a, Gps b) {
        // Simple Haversine (rough) for demo
        double R = 6371.0;
        double dLat = Math.toRadians(b.lat - a.lat);
        double dLon = Math.toRadians(b.lon - a.lon);
        double la1 = Math.toRadians(a.lat);
        double la2 = Math.toRadians(b.lat);
        double h = Math.sin(dLat/2)*Math.sin(dLat/2) +
                   Math.cos(la1)*Math.cos(la2) *
                   Math.sin(dLon/2)*Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1-h));
        return R * c;
    }
}

// 9) Functional interface
@FunctionalInterface
interface FareCalculator {
    double calculateFare(Schedule s, PassengerProfile p);
}

// 10) Marker interface
interface EmergencyService { /* marker */ }

// ===================== Domain models =====================

class Gps {
    final double lat, lon;
    Gps(double lat, double lon) { this.lat = lat; this.lon = lon; }
}

class Route {
    final String routeId;
    final String origin;
    final String destination;
    final Gps originGps;
    final Gps destinationGps;
    Route(String routeId, String origin, String destination, Gps o, Gps d) {
        this.routeId = routeId; this.origin = origin; this.destination = destination;
        this.originGps = o; this.destinationGps = d;
    }
    double distanceKm() {
        return GeoUtils.calculateDistance(originGps, destinationGps);
    }
    @Override public String toString() { return routeId + " (" + origin + " → " + destination + ")"; }
}

class Schedule {
    final String serviceName;     // e.g., "Bus A-12"
    final String serviceType;     // BUS / METRO / TAXI / AMBULANCE
    final Route route;
    final LocalTime departure;
    final double baseFare;
    final boolean surge;          // simulates dynamic pricing

    Schedule(String serviceName, String serviceType, Route route,
             LocalTime departure, double baseFare, boolean surge) {
        this.serviceName = serviceName; this.serviceType = serviceType;
        this.route = route; this.departure = departure; this.baseFare = baseFare; this.surge = surge;
    }
    @Override public String toString() {
        return "[" + serviceType + "] " + serviceName + " | " + route +
               " | dep " + departure + " | base $" + baseFare + (surge ? " (surge)" : "");
    }
}

class PassengerProfile {
    final String name;
    final boolean student;
    final boolean senior;
    PassengerProfile(String name, boolean student, boolean senior) {
        this.name = name; this.student = student; this.senior = senior;
    }
}

// Simple trip record for aggregation/revenue demo
class Trip {
    final Schedule schedule;
    final PassengerProfile passenger;
    final double chargedFare;
    final LocalDateTime timestamp;
    Trip(Schedule s, PassengerProfile p, double chargedFare, LocalDateTime t) {
        this.schedule = s; this.passenger = p; this.chargedFare = chargedFare; this.timestamp = t;
    }
}

// ===================== Implementations =====================

class BusService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    private final FareCalculator fareCalc;

    BusService(String name, List<Schedule> schedules) {
        this.name = name;
        this.schedules = schedules;
        // 1) Lambda expressions for fare calculation (student/senior discount)
        this.fareCalc = (s, p) -> {
            double fare = s.baseFare + 0.15 * s.route.distanceKm(); // base + distance
            if (s.surge) fare *= 1.25;
            if (p.student) fare *= 0.8;
            if (p.senior)  fare *= 0.85;
            return Math.round(fare * 100.0) / 100.0;
        };
    }
    public String getName() { return name; }
    public String getType() { return "BUS"; }
    public List<Schedule> getLiveSchedules() { return schedules; }
    public FareCalculator getFareCalculator() { return fareCalc; }
}

class MetroService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    MetroService(String name, List<Schedule> schedules) {
        this.name = name; this.schedules = schedules;
    }
    public String getName() { return name; }
    public String getType() { return "METRO"; }
    public List<Schedule> getLiveSchedules() { return schedules; }
    public FareCalculator getFareCalculator() {
        // 2) Method reference or lambda to static utility (here simple lambda)
        return (s, p) -> {
            double fare = s.baseFare + 0.10 * s.route.distanceKm();
            return Math.round(fare * 100.0) / 100.0;
        };
    }
}

class TaxiService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    TaxiService(String name, List<Schedule> schedules) {
        this.name = name; this.schedules = schedules;
    }
    public String getName() { return name; }
    public String getType() { return "TAXI"; }
    public List<Schedule> getLiveSchedules() { return schedules; }
    public FareCalculator getFareCalculator() {
        return (s, p) -> {
            double fare = s.baseFare + 0.9 * s.route.distanceKm();
            if (s.surge) fare *= 1.5;
            return Math.round(fare * 100.0) / 100.0;
        };
    }
}

// Emergency service using marker interface
class AmbulanceService implements TransportService, EmergencyService {
    private final String name;
    private final List<Schedule> schedules;
    AmbulanceService(String name, List<Schedule> schedules) {
        this.name = name; this.schedules = schedules;
    }
    public String getName() { return name; }
    public String getType() { return "AMBULANCE"; }
    public List<Schedule> getLiveSchedules() { return schedules; }
    public FareCalculator getFareCalculator() { return (s, p) -> 0.0; } // not billed in demo
}

// Easy extension: new service just implements TransportService
class FerryService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    FerryService(String name, List<Schedule> schedules) { this.name = name; this.schedules = schedules; }
    public String getName() { return name; }
    public String getType() { return "FERRY"; }
    public List<Schedule> getLiveSchedules() { return schedules; }
    public FareCalculator getFareCalculator() {
        return (s, p) -> Math.round((s.baseFare + 0.3 * s.route.distanceKm()) * 100.0) / 100.0;
    }
}

// ===================== Demo / Real-time flow =====================

public class SmartCityDemo {
    public static void main(String[] args) {
        // Sample routes
        Route r1 = new Route("R1","Andheri","BKC", new Gps(19.12,72.85), new Gps(19.07,72.87));
        Route r2 = new Route("R2","BKC","Fort",   new Gps(19.07,72.87), new Gps(18.93,72.83));
        Route r3 = new Route("R3","Airport","Colaba", new Gps(19.09,72.87), new Gps(18.90,72.81));

        // Live schedules (pretend real-time)
        List<Schedule> busSchedules = Arrays.asList(
            new Schedule("Bus A-12","BUS", r1, LocalTime.now().plusMinutes(5),   15, false),
            new Schedule("Bus A-14","BUS", r2, LocalTime.now().plusMinutes(18),  18, true),
            new Schedule("Bus A-18","BUS", r1, LocalTime.now().plusMinutes(32),  15, false)
        );
        List<Schedule> metroSchedules = Arrays.asList(
            new Schedule("Metro M-1","METRO", r1, LocalTime.now().plusMinutes(3),  20, false),
            new Schedule("Metro M-2","METRO", r2, LocalTime.now().plusMinutes(12), 22, false)
        );
        List<Schedule> taxiSlots = Arrays.asList(
            new Schedule("Taxi T-7","TAXI", r3, LocalTime.now().plusMinutes(2),  50, true),
            new Schedule("Taxi T-9","TAXI", r2, LocalTime.now().plusMinutes(9),  40, false)
        );
        List<Schedule> ambulanceSlots = Arrays.asList(
            new Schedule("Ambulance A-ER","AMBULANCE", r3, LocalTime.now().plusMinutes(1), 0, false)
        );
        List<Schedule> ferrySlots = Arrays.asList(
            new Schedule("Ferry F-1","FERRY", r2, LocalTime.now().plusMinutes(25), 30, false)
        );

        // Services
        List<TransportService> services = Arrays.asList(
            new BusService("CityLine Bus", busSchedules),
            new MetroService("Metro Blue", metroSchedules),
            new TaxiService("QuickCab", taxiSlots),
            new AmbulanceService("MedExpress", ambulanceSlots),
            new FerryService("Harbor Ferry", ferrySlots) // 8) extensible
        );

        // 1) Passenger books a trip → Lambda filters and sorts available services
        PassengerProfile alice = new PassengerProfile("Alice", true, false); // student
        // earliest departures within next 20 minutes, then lowest estimated fare
        List<Schedule> shortlisted = services.stream()
            .flatMap(svc -> svc.getLiveSchedules().stream())
            .filter(s -> Duration.between(LocalTime.now(), s.departure).toMinutes() >= 0)
            .filter(s -> Duration.between(LocalTime.now(), s.departure).toMinutes() <= 20)
            .sorted(Comparator
                .comparing((Schedule s) -> Duration.between(LocalTime.now(), s.departure).toMinutes())
                .thenComparing(s -> servicesOf(services, s.serviceName).getFareCalculator().calculateFare(s, alice))
            )
            .collect(Collectors.toList());

        System.out.println("\n--- Shortlisted (≤20 min): earliest then lowest fare for Alice ---");
        shortlisted.forEach(System.out::println); // 2) Method reference for printing

        // Choose the first one (if any) and compute fare
        shortlisted.stream().findFirst().ifPresent(s -> {
            TransportService svc = servicesOf(services, s.serviceName);
            double fare = svc.getFareCalculator().calculateFare(s, alice);
            System.out.println("\nChosen: " + s + " | Estimated Fare: $" + fare);
        });

        // 2) Method References – quick printing & logging
        System.out.println("\n--- Service Details ---");
        services.forEach(TransportService::printServiceDetails);

        // 6) forEach → dashboard display of all live schedules
        System.out.println("\n--- Dashboard: Live Schedules (all) ---");
        Consumer<Schedule> dashboard = System.out::println; // method reference
        services.forEach(svc -> svc.pushToDashboard(dashboard));

        // Simulated completed trips (for revenue analytics)
        List<Trip> trips = simulateTrips(services);

        // 7) Collectors – groupingBy: passengers by route (using trip count as proxy)
        Map<String, Long> passengersByRoute = trips.stream()
            .collect(Collectors.groupingBy(t -> t.schedule.route.routeId, Collectors.counting()));
        System.out.println("\nPassengers by route: " + passengersByRoute);

        // 7) partitioningBy: peak vs non-peak (peak: 08–10 or 17–19)
        Predicate<Trip> isPeak = t -> {
            int h = t.timestamp.getHour();
            return (h >= 8 && h < 10) || (h >= 17 && h < 19);
        };
        Map<Boolean, List<Trip>> peakPartition = trips.stream()
            .collect(Collectors.partitioningBy(isPeak));
        System.out.println("\nTrips partitioned by peak: " +
            peakPartition.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size())));

        // 7) summarizingDouble: total & average fares collected overall
        DoubleSummaryStatistics fareStats = trips.stream()
            .collect(Collectors.summarizingDouble(t -> t.chargedFare));
        System.out.println("\nRevenue (all trips): count=" + fareStats.getCount() +
            ", sum=" + fareStats.getSum() +
            ", avg=" + fareStats.getAverage() +
            ", max=" + fareStats.getMax());

        // 5) Stream APIs – top used routes (by trip count)
        List<Map.Entry<String, Long>> topRoutes = passengersByRoute.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("\nTop routes: " + topRoutes);

        // 9) Functional interface with lambdas already used above
        // 10) Marker interface – detect & prioritize emergency services
        boolean emergencyActive = services.stream().anyMatch(svc -> svc instanceof EmergencyService);
        System.out.println("\nEmergency mode active? " + emergencyActive);
        if (emergencyActive) {
            System.out.println("Prioritizing emergency vehicles on all routes.");
        }
    }

    // Helper: find service that owns a schedule by its serviceName
    private static TransportService servicesOf(List<TransportService> services, String serviceName) {
        return services.stream()
            .filter(svc -> svc.getLiveSchedules().stream().anyMatch(sc -> sc.serviceName.equals(serviceName)))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Service not found for schedule: " + serviceName));
    }

    // Create some completed trips for aggregation demo
    private static List<Trip> simulateTrips(List<TransportService> services) {
        PassengerProfile alice = new PassengerProfile("Alice", true, false);
        PassengerProfile bob   = new PassengerProfile("Bob",   false, false);
        PassengerProfile rita  = new PassengerProfile("Rita",  false, true);

        List<Schedule> all = services.stream().flatMap(s -> s.getLiveSchedules().stream()).collect(Collectors.toList());
        Random rnd = new Random(7);

        // Generate random trips in past few hours
        List<PassengerProfile> pax = Arrays.asList(alice, bob, rita);
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Schedule s = all.get(rnd.nextInt(all.size()));
            PassengerProfile p = pax.get(rnd.nextInt(pax.size()));
            TransportService svc = servicesOf(services, s.serviceName);
            double fare = svc.getFareCalculator().calculateFare(s, p);
            LocalDateTime when = LocalDateTime.now().minusMinutes(rnd.nextInt(300));
            trips.add(new Trip(s, p, fare, when));
        }
        return trips;
    }
}
