import java.util.Scanner;

public class BMICalculator {
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            double weight = scanner.nextDouble();
            double height = scanner.nextDouble();
            double bmi = calculateBMI(weight, height);
            data[i][0] = weight;
            data[i][1] = height;
            data[i][2] = bmi;
            status[i] = determineBMIStatus(bmi);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": Weight = " + data[i][0] + " kg, Height = " + data[i][1] + " cm, BMI = " + data[i][2] + ", Status = " + status[i]);
        }
    }
}