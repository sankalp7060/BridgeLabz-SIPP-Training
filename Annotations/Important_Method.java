import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod(level = "CRITICAL")
    public void process() {}

    @ImportantMethod
    public void save() {}
}

public class Important_Method {
    public static void main(String[] args) throws Exception {
        for (Method m : Service.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " - Level: " + im.level());
            }
        }
    }
}
