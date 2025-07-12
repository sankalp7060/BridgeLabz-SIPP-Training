public class StringConcatComparison {
    public static String concatString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "a"; 
        }
        return s;
    }
    public static String concatStringBuilder(int n) {
        char[] buffer = new char[n];
        for (int i = 0; i < n; i++) {
            buffer[i] = 'a';
        }
        return new String(buffer);
    }
    public static synchronized String concatStringBuffer(int n) {
        char[] buffer = new char[n];
        for (int i = 0; i < n; i++) {
            buffer[i] = 'a';
        }
        return new String(buffer);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
            long start;

            start = System.nanoTime();
            concatString(size);
            long timeStr = System.nanoTime() - start;

            start = System.nanoTime();
            concatStringBuilder(size);
            long timeSB = System.nanoTime() - start;

            start = System.nanoTime();
            concatStringBuffer(size);
            long timeSBuf = System.nanoTime() - start;

            System.out.printf("N=%d | String: %d ms | Manual StringBuilder: %d ms | Manual StringBuffer: %d ms\n",
                    size, timeStr / 1_000_000, timeSB / 1_000_000, timeSBuf / 1_000_000);
        }
    }
}
