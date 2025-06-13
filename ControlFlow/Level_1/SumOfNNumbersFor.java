import java.util.Scanner;

public class SumOfNNumbersFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        int formulaSum = n * (n + 1) / 2;
        System.out.println("Sum using for loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Results are equal: " + (sum == formulaSum));
    }
}
