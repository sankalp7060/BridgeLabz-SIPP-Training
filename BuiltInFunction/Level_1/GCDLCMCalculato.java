import java.util.Scanner;

public class GCDLCMCalculator {

    public static void main(String[] args) {
        int[] nums = getInput();
        int gcd = calculateGCD(nums[0], nums[1]);
        int lcm = calculateLCM(nums[0], nums[1], gcd);
        displayResult(nums[0], nums[1], gcd, lcm);
    }

    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        sc.close();
        return new int[]{a, b};
    }

    public static int calculateGCD(int a, int b) {
        if (b == 0) return a;
        return calculateGCD(b, a % b);
    }

    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }

    public static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
