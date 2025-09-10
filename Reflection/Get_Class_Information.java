import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Get_Class_Information {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList"); 

        System.out.println("Class: " + clazz.getName());

        System.out.println("\n--- Methods ---");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println("\n--- Fields ---");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }

        System.out.println("\n--- Constructors ---");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }
    }
}

