import java.lang.reflect.Method;

class Task {
    public void doWork() {
        for (int i = 0; i < 1_000_000; i++); 
    }
}

public class Method_Execution_Timing {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("doWork");

        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();

        System.out.println("Execution time: " + (end - start) + " ns");
    }
}
