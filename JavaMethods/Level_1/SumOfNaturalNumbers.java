import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static int sumNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = sumNaturalNumbers(n);
        System.out.println("Sum of " + n + " natural numbers is: " + result);
    }
}