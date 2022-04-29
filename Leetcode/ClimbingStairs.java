import java.util.Arrays;

//leetcode 70
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    //leetcode 746
    public static int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        int d = cost[l - 2];
        int u = cost[l - 1];
        for (int i = l - 3; i >= 0; i--) {
            int swap = d;
            d = cost[i] + Math.min(u, d);
            u = swap;
        }
        return Math.min(u, d);
    }

    /**
     * fibonnaci series implemented to get the climbing steps count
     */
    public static int climbStairsUsingFib(int n) {
        int x = 1;
        int y = 1;
        for (int i = 0; i < n - 1; i++) {
            int r = x;
            x = x + y;
            y = r;
        }
        return x;
    }

    //    brute force method
    public static int climbStairs(int n) {

        return waysToClimb(n, 0, 1) + waysToClimb(n, 0, 2);
    }

    static int waysToClimb(int n, int currentPos, int climbStep) {
        currentPos += climbStep;
        if (n == currentPos) {
            return 1;
        }
        if (n < currentPos) {
            return 0;
        }

        return waysToClimb(n, currentPos, 1) + waysToClimb(n, currentPos, 2);

    }

}
