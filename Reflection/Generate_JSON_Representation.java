import java.lang.reflect.Field;

class User {
    String username = "Alice";
    int age = 25;
}

public class Generate_JSON_Representation {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            sb.append("\"").append(f.getName()).append("\":\"")
              .append(f.get(obj)).append("\",");
        }
        sb.deleteCharAt(sb.length() - 1).append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        System.out.println(toJson(user));
    }
}
