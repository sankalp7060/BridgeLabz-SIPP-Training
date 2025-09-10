import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    User(String username) throws Exception {
        for (var field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                int max = field.getAnnotation(MaxLength.class).value();
                if (username.length() > max) {
                    throw new IllegalArgumentException("Username too long! Max: " + max);
                }
            }
        }
        this.username = username;
    }
}

public class Max_Length {
    public static void main(String[] args) throws Exception {
        User u1 = new User("Alice");  // OK
        User u2 = new User("VeryLongUsernameHere"); // Throws exception
    }
}
