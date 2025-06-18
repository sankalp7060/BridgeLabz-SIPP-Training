import java.util.*;

public class UniqueCharacters {
    public static String findUniqueCharacters(String str) {
        String unique = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (unique.indexOf(ch) == -1) {
                unique += ch;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String result = findUniqueCharacters(input);
        System.out.println("Unique characters: " + result);
    }
}
