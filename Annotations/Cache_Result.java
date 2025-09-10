import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveService {
    private final Map<Integer, Long> cache = new HashMap<>();

    @CacheResult
    public long factorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for " + n);
            return cache.get(n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        cache.put(n, result);
        return result;
    }
}

public class Cache_Result {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();
        System.out.println(service.factorial(10)); // computed
        System.out.println(service.factorial(10)); // cached
    }
}
