import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(50, 100));
    }

    public static int uniquePaths(int m, int n) {
        HashMap<String, Integer> memo = new HashMap<>();
        return uniquePaths(m, n, 1, 1, memo);
    }

    private static int uniquePaths(int m, int n, int x, int y, Map<String, Integer> memo) {
        String k = x + ":" + y;
        if (memo.containsKey(k)) return memo.get(k);
        if (m == x || n == y) return 1;
        memo.put(k, uniquePaths(m, n, x + 1, y, memo) + uniquePaths(m, n, x, y + 1, memo));
        return memo.get(k);
    }

}
