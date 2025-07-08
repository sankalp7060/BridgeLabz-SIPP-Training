import java.util.*;

public class Truck extends Vehicle {
    public Truck(String model) {
        super(model, getTruckBasePrice(model));
    }

    private static double getTruckBasePrice(String model) {
        List<String> light = Arrays.asList("Tata Ace", "Mahindra Jeeto");
        List<String> heavy = Arrays.asList("Ashok Leyland", "BharatBenz");

        if (light.contains(model)) return 2500;
        else if (heavy.contains(model)) return 4000;
        else return 3000;
    }

    @Override
    public double calculateRent(int numberOfDays) {
        return basePrice * numberOfDays;
    }
}
