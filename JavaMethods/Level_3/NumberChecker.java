public class NumberChecker {

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

    public static boolean isDuckNumber(int number) {
        while (number != 0) {
            if (number % 10 == 0) return true;
            number /= 10;
        }
        return false;
    }

    public static boolean isArmstrong(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, digits.length);
        }
        return sum == number;
    }

    public static int findLargest(int[] digits) {
        int max = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max) max = d;
        }
        return max;
    }

    public static int findSecondLargest(int[] digits) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max) {
                secondMax = max;
                max = d;
            } else if (d > secondMax && d < max) {
                secondMax = d;
            }
        }
        return secondMax;
    }

    public static int findSmallest(int[] digits) {
        int min = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min) min = d;
        }
        return min;
    }

    public static int findSecondSmallest(int[] digits) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min) {
                secondMin = min;
                min = d;
            } else if (d < secondMin && d > min) {
                secondMin = d;
            }
        }
        return secondMin;
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = storeDigits(number);

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.println("Duck number: " + isDuckNumber(number));
        System.out.println("Armstrong number: " + isArmstrong(number));
        System.out.println("Largest digit: " + findLargest(digits));
        System.out.println("Second largest digit: " + findSecondLargest(digits));
        System.out.println("Smallest digit: " + findSmallest(digits));
        System.out.println("Second smallest digit: " + findSecondSmallest(digits));
    }
}