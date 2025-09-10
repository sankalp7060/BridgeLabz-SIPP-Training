import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    void run() { System.out.println("Service running..."); }
}

class Controller {
    @Inject
    private Service service;

    void execute() {
        service.run();
    }
}

public class Dependency_Injection {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();

        for (Field f : Controller.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(controller, new Service());
            }
        }

        controller.execute();
    }
}

