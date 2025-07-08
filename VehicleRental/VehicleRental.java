import java.util.*;
import java.util.stream.*;

public class VehicleRental {
    static final List<String> availableBikes = Arrays.asList("Splendor", "Pulsar", "Apache");
    static final List<String> availableSedans = Arrays.asList("Honda City", "Verna", "Alto");
    static final List<String> availableXUVs = Arrays.asList("Thar", "Scorpio", "GWagen");
    static final List<String> availableSportsCars = Arrays.asList("Lambo", "Koengseg", "F1");
    static final List<String> availableLightTrucks = Arrays.asList("Tata Ace", "Mahindra Jeeto");
    static final List<String> availableHeavyTrucks = Arrays.asList("Ashok Leyland", "BharatBenz");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Customer customer = new Customer(name);
        History history = new History();

        System.out.print("\nHow many vehicles do you want to rent? ");
        int totalVehicles = sc.nextInt();
        sc.nextLine();

        double totalRent = 0.0;

        for (int i = 1; i <= totalVehicles; i++) {
            System.out.println("\nVehicle #" + i + ":");
            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.nextLine().toLowerCase();

            Vehicle vehicle = null;
            String model = "";

            switch (type) {
                case "bike":
                    System.out.println("Available Bikes: " + availableBikes);
                    model = getValidModel(sc, availableBikes, "bike");
                    vehicle = new Bike(model);
                    break;

                case "car":
                    List<String> allCars = new ArrayList<>();
                    allCars.addAll(availableSedans);
                    allCars.addAll(availableXUVs);
                    allCars.addAll(availableSportsCars);
                    System.out.println("Available Cars:");
                    System.out.println("Sedan: " + availableSedans);
                    System.out.println("XUV: " + availableXUVs);
                    System.out.println("Sports: " + availableSportsCars);
                    model = getValidModel(sc, allCars, "car");
                    vehicle = new Car(model);
                    break;

                case "truck":
                    List<String> allTrucks = new ArrayList<>();
                    allTrucks.addAll(availableLightTrucks);
                    allTrucks.addAll(availableHeavyTrucks);
                    System.out.println("Available Trucks:");
                    System.out.println("Light: " + availableLightTrucks);
                    System.out.println("Heavy: " + availableHeavyTrucks);
                    model = getValidModel(sc, allTrucks, "truck");
                    vehicle = new Truck(model);
                    break;

                default:
                    System.out.println("Invalid vehicle type. Try again.");
                    i--;
                    continue;
            }

            System.out.print("Enter number of days to rent: ");
            int days = sc.nextInt();
            sc.nextLine();

            double rent = vehicle.calculateRent(days);
            totalRent += rent;

            history.addRecord(type, model, days, rent);
        }

        history.printHistory(customer.getName(), totalRent);
    }

    public static String getValidModel(Scanner sc, List<String> availableModels, String type) {
    while (true) {
        System.out.print("Enter model name from the list above: ");
        String input = sc.nextLine().trim().toLowerCase();

        int index = -1;
        int i = 0;
        while (i < availableModels.size()) {
            if (availableModels.get(i).toLowerCase().equals(input)) {
                index = i;
                break;
            }
            i++;
        }

        if (index != -1) {
            return availableModels.get(index); 
        } else {
            System.out.println("Invalid " + type + " model. Please choose from the list.");
        }
    }
}

}
