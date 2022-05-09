import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }


    //leetcode 198
    //this solution is an optimized dynamic programming algorithm
    //this can be solved by O(n) time complexity if we use variable swap method
    public static int rob(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.max(rob(nums, 0, length, memo), rob(nums, 1, length, memo));
    }

    private static int rob(int[] nums, int pos, int length, Map<Integer, Integer> memo) {
        if (memo.containsKey(pos)) return memo.get(pos);
        if (pos >= length) return 0;
        if (length - pos <= 2) return nums[pos];
        memo.put(pos, Math.max(rob(nums, pos + 2, length, memo), rob(nums, pos + 3, length, memo)) + nums[pos]);
        return memo.get(pos);
    }
}
