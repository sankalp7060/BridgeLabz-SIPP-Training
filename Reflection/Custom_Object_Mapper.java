import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Employee {
    String name;
    int age;
}

public class Custom_Object_Mapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (var entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", 28);

        Employee emp = toObject(Employee.class, props);
        System.out.println("Employee: " + emp.name + ", Age: " + emp.age);
    }
}
