
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserProfile {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_age")
    int age;

    UserProfile(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class Json_Field {
    public static void main(String[] args) throws Exception {
        UserProfile user = new UserProfile("Alice", 25);

        StringBuilder json = new StringBuilder("{");
        for (var field : user.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jf = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                json.append("\"").append(jf.name()).append("\": \"")
                    .append(field.get(user)).append("\", ");
            }
        }
        json.delete(json.length() - 2, json.length());
        json.append("}");

        System.out.println(json.toString());
    }
}
