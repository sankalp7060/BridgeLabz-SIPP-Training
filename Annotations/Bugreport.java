import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "UI glitch on login")
    public void run() {
        System.out.println("Running software...");
    }
}

public class Bugreport {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("run");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport br : reports) {
            System.out.println("Bug: " + br.description());
        }
    }
}
