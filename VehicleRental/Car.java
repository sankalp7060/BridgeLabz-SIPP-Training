import java.util.*;

public class Car extends Vehicle {
    public Car(String model) {
        super(model, getCarBasePrice(model));
    }

    private static double getCarBasePrice(String model) {
        List<String> sedan = Arrays.asList("Honda City", "Verna", "Alto");
        List<String> xuv = Arrays.asList("Thar", "Scorpio", "GWagen");
        List<String> sports = Arrays.asList("Lambo", "Koengseg", "F1");

        if (sedan.contains(model)) return 1000;
        else if (xuv.contains(model)) return 2000;
        else if (sports.contains(model)) return 3000;
        else return 1500;
    }

    @Override
    public double calculateRent(int numberOfDays) {
        return basePrice * numberOfDays;
    }
}
