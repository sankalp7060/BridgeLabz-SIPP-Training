import java.util.Scanner;

public class FactorialRecursion {

    public static void main(String[] args) {
        int number = getInput();
        long result = factorial(number);
        displayResult(number, result);
    }

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void displayResult(int num, long result) {
        System.out.println("Factorial of " + num + " is: " + result);
    }
}
