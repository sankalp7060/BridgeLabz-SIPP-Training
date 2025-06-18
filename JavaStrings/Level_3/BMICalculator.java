import java.util.*;

public class BMICalculator {
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        String[][] data = new String[n][4];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter height (m): ");
            double height = sc.nextDouble();
            System.out.print("Enter weight (kg): ");
            double weight = sc.nextDouble();

            double bmi = calculateBMI(weight, height);
            String status = getBMICategory(bmi);

            data[i][0] = name;
            data[i][1] = String.valueOf(weight);
            data[i][2] = String.valueOf(height);
            data[i][3] = status;
        }

        System.out.println("Name\tWeight\tHeight\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1] + "\t" + data[i][2] + "\t" + data[i][3]);
        }
    }
}