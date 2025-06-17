import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        if (number < 0) {
            number = -number;
        }

        int[] frequency = new int[10];
        int[] digits = new int[20];
        int index = 0;

        while (number != 0) {
            int digit = (int)(number % 10);
            digits[index++] = digit;
            number = number / 10;
        }

        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }

        scanner.close();
    }
}
