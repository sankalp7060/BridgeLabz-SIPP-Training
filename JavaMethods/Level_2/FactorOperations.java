import java.util.Scanner;

public class FactorOperations {
    public static int[] getFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int n : arr) total += n;
        return total;
    }

    public static int product(int[] arr) {
        int prod = 1;
        for (int n : arr) prod *= n;
        return prod;
    }

    public static int sumOfSquares(int[] arr) {
        int total = 0;
        for (int n : arr) total += Math.pow(n, 2);
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] factors = getFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Sum of factors: " + sum(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
        System.out.println("Product of factors: " + product(factors));
    }
}