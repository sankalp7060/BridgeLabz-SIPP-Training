public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] fibInputs = {10, 30, 45};

        for (int n : fibInputs) {
            long start;

            if (n <= 30) {
                start = System.nanoTime();
                fibonacciRecursive(n);
                long timeRec = System.nanoTime() - start;
                System.out.printf("N=%d | Recursive: %d ms | ", n, timeRec / 1_000_000);
            } else {
                System.out.printf("N=%d | Recursive: Unfeasible | ", n);
            }

            start = System.nanoTime();
            fibonacciIterative(n);
            long timeIter = System.nanoTime() - start;

            System.out.printf("Iterative: %d ms\n", timeIter / 1_000_000);
        }
    }
}
