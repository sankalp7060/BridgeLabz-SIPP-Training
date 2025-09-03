import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

public class LibraryStats {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Fiction", 300),
            new Book("Fiction", 250),
            new Book("Science", 500),
            new Book("Science", 450),
            new Book("History", 600)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)));

        System.out.println(stats);
    }
}
