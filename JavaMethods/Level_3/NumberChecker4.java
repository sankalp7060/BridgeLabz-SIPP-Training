public class NumberChecker4 {

    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int n = countDigits(number);
        int[] digits = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int reverseNumber(int number) {
        int reverse = 0;
        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return reverse;
    }

    public static boolean isPalindrome(int number) {
        return number == reverseNumber(number);
    }

    public static boolean isDuckNumber(int number) {
        while (number != 0) {
            if (number % 10 == 0) return true;
            number /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 1221;
        int[] digits = storeDigits(number);

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.println("Reversed number: " + reverseNumber(number));
        System.out.println("Is Palindrome: " + isPalindrome(number));
        System.out.println("Is Duck Number: " + isDuckNumber(number));
    }
}