import java.util.*;
class Reservation {
    String customerName;
    int tableNumber;
    String reservationTime;

    public Reservation(String customerName, int tableNumber, String reservationTime) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.reservationTime = reservationTime;
    }
}

class ReservationSystem<T extends Reservation> {
    Set<String> reservationKeys = new HashSet<>();
    List<T> reservations = new ArrayList<>();

    public void addReservation(T reservation) {
        String key = reservation.tableNumber + reservation.reservationTime;
        if (!reservationKeys.contains(key)) {
            reservations.add(reservation);
            reservationKeys.add(key);
        }
    }

    public void viewReservations() {
        reservations.sort(Comparator.comparing(r -> r.reservationTime));
        for (T r : reservations) {
            System.out.println(r.customerName + " reserved table " + r.tableNumber + " at " + r.reservationTime);
        }
    }
}

public class RestaurantReservationSystem {
    public static void main(String[] args) {
        ReservationSystem<Reservation> resSys = new ReservationSystem<>();
        resSys.addReservation(new Reservation("Alice", 5, "7:00 PM"));
        resSys.addReservation(new Reservation("Bob", 3, "6:30 PM"));
        resSys.addReservation(new Reservation("Alice", 5, "7:00 PM")); // duplicate

        resSys.viewReservations();
    }
}