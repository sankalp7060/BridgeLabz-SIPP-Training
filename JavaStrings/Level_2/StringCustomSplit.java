import java.util.Scanner;

public class StringCustomSplit {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    public static String[] customSplit(String text) {
        int length = findLength(text);
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int[] spaceIndexes = new int[spaceCount + 2]; 
        spaceIndexes[0] = -1; 
        int idx = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }
        spaceIndexes[idx] = length; 
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];

            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(text.charAt(j));
            }
            words[i] = word.toString();
        }

        return words;
    }
    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String[] builtinWords = input.split(" ");
        String[] customWords = customSplit(input);
        System.out.println("\nBuilt-in split result:");
        for (String word : builtinWords) {
            System.out.println(word);
        }
        System.out.println("\nCustom split result:");
        for (String word : customWords) {
            System.out.println(word);
        }
        boolean areEqual = compareStringArrays(builtinWords, customWords);
        System.out.println("\nComparison Result: " + (areEqual ? "Both arrays are equal." : "Arrays are different."));
    }
}
