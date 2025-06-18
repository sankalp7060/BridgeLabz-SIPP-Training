import java.util.Scanner;

public class UnitConverter1 {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double km = scanner.nextDouble();
        double miles = scanner.nextDouble();
        double meters = scanner.nextDouble();
        double feet = scanner.nextDouble();

        System.out.println("Km to Miles: " + convertKmToMiles(km));
        System.out.println("Miles to Km: " + convertMilesToKm(miles));
        System.out.println("Meters to Feet: " + convertMetersToFeet(meters));
        System.out.println("Feet to Meters: " + convertFeetToMeters(feet));
    }
}