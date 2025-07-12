import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) throws IOException {
        String path = "largefile.txt"; 
        long start = System.nanoTime();
        FileReader fr = new FileReader(path);
        while (fr.read() != -1) {}
        fr.close();
        long timeFR = System.nanoTime() - start;
        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
        while (isr.read() != -1) {}
        isr.close();
        long timeISR = System.nanoTime() - start;

        System.out.printf("FileReader: %d ms | InputStreamReader: %d ms\n",
                timeFR / 1_000_000, timeISR / 1_000_000);
    }
}
