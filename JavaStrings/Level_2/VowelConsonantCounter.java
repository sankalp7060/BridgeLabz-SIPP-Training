import java.util.Scanner;

public class VowelConsonantCounter {

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
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

    public static int[] countVowelsAndConsonants(String input) {
        int vowels = 0;
        int consonants = 0;

        int index = 0;
        try {
            while (true) {
                char ch = input.charAt(index);
                String type = checkCharacterType(ch);
                if (type.equals("Vowel")) {
                    vowels++;
                } else if (type.equals("Consonant")) {
                    consonants++;
                }
                index++;
            }
        } catch (Exception e) {
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(input);

        System.out.println("\nVowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}
