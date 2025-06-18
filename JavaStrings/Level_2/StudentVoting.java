import java.util.Scanner;
import java.util.Random;

public class StudentVoting {

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; 
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false"; 
            } else if (age >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    public static void displayResultTable(String[][] table) {
        System.out.printf("%-10s %-15s\n", "Age", "Can Vote");
        System.out.println("-------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-10s %-15s\n", table[i][0], table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] ages = generateRandomAges(n);
        String[][] votingStatus = checkVotingEligibility(ages);

        System.out.println("\nVoting Eligibility Table:");
        displayResultTable(votingStatus);
    }
}
