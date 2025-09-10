import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Calculator {
    @LogExecutionTime
    public void compute() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) sum += i;
        System.out.println("Sum: " + sum);
    }
}

public class Log_Execution_Time {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method m = calc.getClass().getMethod("compute");

        if (m.isAnnotationPresent(LogExecutionTime.class)) {
            long start = System.nanoTime();
            m.invoke(calc);
            long end = System.nanoTime();
            System.out.println("Execution Time: " + (end - start) + " ns");
        }
    }
}
