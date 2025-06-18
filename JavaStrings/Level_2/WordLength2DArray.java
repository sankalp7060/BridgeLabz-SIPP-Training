import java.util.Scanner;

public class WordLength2DArray {
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
    public static String[][] wordLength2DArray(String[] words) {
        int len = words.length;
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLength = findLength(word);
            result[i][0] = word;
            result[i][1] = String.valueOf(wordLength);  
        }

        return result;
    }
    public static void displayTable(String[][] table) {
        System.out.printf("%-20s %-10s\n", "Word", "Length");
        System.out.println("-------------------- ----------");

        for (String[] row : table) {
            String word = row[0];
            int length = Integer.parseInt(row[1]); 
            System.out.printf("%-20s %-10d\n", word, length);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String[] words = customSplit(input);
        String[][] wordLengthTable = wordLength2DArray(words);
        System.out.println("\nWord and Length Table:");
        displayTable(wordLengthTable);
    }
}
