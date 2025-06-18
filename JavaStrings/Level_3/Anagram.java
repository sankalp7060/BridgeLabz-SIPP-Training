import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("Are Anagrams: " + isAnagram(str1, str2));
    }
}
