import java.util.Scanner;

public class CustomTrimString {

    public static int[] findTrimIndices(String str) {
        int start = 0;
        int end = 0;

        try {
            while (true) {
                str.charAt(end);
                end++;
            }
        } catch (Exception e) {}

        int i = 0;
        while (i < end) {
            if (str.charAt(i) != ' ') {
                break;
            }
            i++;
        }
        start = i;

        i = end - 1;
        while (i >= 0) {
            if (str.charAt(i) != ' ') {
                break;
            }
            i--;
        }
        end = i;

        return new int[]{start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        int i = 0;
        try {
            while (true) {
                if (s1.charAt(i) != s2.charAt(i)) return false;
                i++;
            }
        } catch (Exception e) {}

        try {
            s2.charAt(i);
            return false;
        } catch (Exception e) {}

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = scanner.nextLine();

        int[] indices = findTrimIndices(input);
        String customTrimmed = "";
        if (indices[0] <= indices[1]) {
            customTrimmed = customSubstring(input, indices[0], indices[1]);
        }

        String builtInTrimmed = input.trim();
        boolean isEqual = compareStrings(customTrimmed, builtInTrimmed);

        System.out.println("\nCustom Trimmed: '" + customTrimmed + "'");
        System.out.println("Built-in Trimmed: '" + builtInTrimmed + "'");
        System.out.println("Are both equal? " + isEqual);

        scanner.close();
    }
}
