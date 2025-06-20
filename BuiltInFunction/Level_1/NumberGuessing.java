import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");

        waitForUserConfirmation(sc);

        int low = 1, high = 100;

        while (low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "?");
            String feedback = getUserFeedback(sc);

            if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! I guessed your number correctly.");
                break;
            } else {
                System.out.println("Invalid input. Please type: low, high, or correct.");
            }

            if (low > high) {
                System.out.println("Inconsistent feedback. Please restart and give correct hints.");
                break;
            }
        }
    }

    public static void waitForUserConfirmation(Scanner sc) {
        while (true) {
            System.out.print("Have you thought of a number? (yes/no): ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("yes")) break;
        }
    }

    public static int generateGuess(int low, int high) {
        return low + (high - low) / 2;
    }

    public static String getUserFeedback(Scanner sc) {
        System.out.print("Enter your feedback (low/high/correct): ");
        return sc.nextLine().trim();
    }
}
