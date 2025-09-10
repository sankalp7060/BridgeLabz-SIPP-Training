import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {}

public class Retrieve_Annotations {
    public static void main(String[] args) {
        Author author = Book.class.getAnnotation(Author.class);
        if (author != null) {
            System.out.println("Author: " + author.name());
        }
    }
}
