public class FactorsUtil {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors, int number) {
        int max = 1;
        for (int f : factors) {
            if (f < number && f > max) max = f;
        }
        return max;
    }

    public static void main(String[] args) {
        int number = 36;
        int[] factors = findFactors(number);

        System.out.println("Number: " + number);
        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();
        System.out.println("Greatest proper factor: " + findGreatestFactor(factors, number));
    }
}