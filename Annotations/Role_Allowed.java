import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }
}

public class Role_Allowed {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // simulate user

        SecureService service = new SecureService();
        Method m = service.getClass().getMethod("adminTask");

        RoleAllowed role = m.getAnnotation(RoleAllowed.class);
        if (role != null && !role.value().equals(currentUserRole)) {
            System.out.println("Access Denied!");
        } else {
            m.invoke(service);
        }
    }
}
