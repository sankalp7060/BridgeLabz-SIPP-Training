import java.util.Random;

public class EmployeeBonus {

    public static int[][] generateSalariesAndService(int count) {
        Random rand = new Random();
        int[][] data = new int[count][2];
        for (int i = 0; i < count; i++) {
            data[i][0] = 10000 + rand.nextInt(90000);
            data[i][1] = rand.nextInt(11);
        }
        return data;
    }

    public static double calculateBonus(int salary, int serviceYears) {
        if (serviceYears > 5) return salary * 0.05;
        else return salary * 0.02;
    }

    public static void displaySalaryTable(int[][] data) {
        double totalOldSalary = 0, totalBonus = 0, totalNewSalary = 0;

        System.out.printf("%-10s%-12s%-10s%-10s%-12s\n", "Emp ID", "Salary", "Years", "Bonus", "New Salary");

        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus = calculateBonus(salary, years);
            double newSalary = salary + bonus;

            totalOldSalary += salary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%-10d%-12d%-10d%-10.2f%-12.2f\n", (i + 1), salary, years, bonus, newSalary);
        }

        System.out.println("\nTOTAL OLD SALARY  : " + totalOldSalary);
        System.out.println("TOTAL BONUS       : " + totalBonus);
        System.out.println("TOTAL NEW SALARY  : " + totalNewSalary);
    }

    public static void main(String[] args) {
        int[][] data = generateSalariesAndService(10);
        displaySalaryTable(data);
    }
}