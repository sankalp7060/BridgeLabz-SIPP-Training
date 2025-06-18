import java.util.Scanner;

public class WordMinMaxLength {

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

    public static int[] findShortestAndLongest(String[][] wordLengthArray) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < wordLengthArray.length; i++) {
            int len = Integer.parseInt(wordLengthArray[i][1]);
            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] words = customSplit(input);
        String[][] wordLengthTable = wordLength2DArray(words);
        int[] result = findShortestAndLongest(wordLengthTable);

        System.out.println("\nShortest word: " + wordLengthTable[result[0]][0] + " (Length: " + wordLengthTable[result[0]][1] + ")");
        System.out.println("Longest word: " + wordLengthTable[result[1]][0] + " (Length: " + wordLengthTable[result[1]][1] + ")");
    }
}
