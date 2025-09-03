import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String paragraph = "Java stream API makes Java powerful powerful and flexible";
        String[] words = paragraph.split("\\s+");

        Map<String, Long> freq = Arrays.stream(words)
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1L,
                        Long::sum 
                ));

        System.out.println(freq);
    }
}
