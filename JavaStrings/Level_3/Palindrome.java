import java.util.Scanner;

public class Palindrome {
    static boolean checkUsingLoop(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    static boolean checkUsingReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    static boolean checkUsingRecursion(String str, int start, int end) {
        if (start >= end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        return checkUsingRecursion(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Using Loop: " + checkUsingLoop(str));
        System.out.println("Using Reverse: " + checkUsingReverse(str));
        System.out.println("Using Recursion: " + checkUsingRecursion(str, 0, str.length() - 1));
    }
}
