import java.util.Scanner;

public class CharacterClassifier {

    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); 
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] classifyCharacters(String str) {
        int index = 0;
        int length = 0;
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (Exception e) {}

        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }

        return result;
    }

    public static void displayClassificationTable(String[][] table) {
        System.out.printf("%-10s %-15s\n", "Character", "Type");
        System.out.println("-------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-10s %-15s\n", table[i][0], table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] classified = classifyCharacters(input);
        System.out.println("\nCharacter Classification:");
        displayClassificationTable(classified);

        scanner.close();
    }
}
