import java.util.*;

public class BookShelf {
    private Map<String, LinkedList<String>> genreMap = new HashMap<>();
    private Set<String> allBooks = new HashSet<>(); // Optional: prevent duplicates

    public void addBook(String genre, String bookName) {
        genreMap.putIfAbsent(genre, new LinkedList<>());
        if (allBooks.add(bookName)) { // returns false if already present
            genreMap.get(genre).add(bookName);
            System.out.println("Added: " + bookName + " to genre: " + genre);
        } else {
            System.out.println("Duplicate book ignored: " + bookName);
        }
    }

    public void removeBook(String genre, String bookName) {
        if (genreMap.containsKey(genre)) {
            genreMap.get(genre).remove(bookName);
            allBooks.remove(bookName);
            System.out.println("Removed: " + bookName + " from genre: " + genre);
        }
    }

    public void showCatalog() {
        for (String genre : genreMap.keySet()) {
            System.out.println(genre + ": " + genreMap.get(genre));
        }
    }

    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addBook("Fiction", "Harry Potter");
        shelf.addBook("Fiction", "Lord of the Rings");
        shelf.addBook("Science", "A Brief History of Time");
        shelf.addBook("Fiction", "Harry Potter"); // Duplicate
        shelf.removeBook("Fiction", "Lord of the Rings");
        shelf.showCatalog();
    }
}
