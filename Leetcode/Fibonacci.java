import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Map<Integer, Long> memoizationMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fib(49));
    }

    private static long fib(int n) {
        if (memoizationMap.get(n) != null) return memoizationMap.get(n);
        if (n <= 2) return 1L;
        memoizationMap.put(n, fib(n - 1) + fib(n - 2));
        return memoizationMap.get(n);
    }
}
