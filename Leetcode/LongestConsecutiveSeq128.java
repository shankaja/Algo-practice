import java.util.*;

public class LongestConsecutiveSeq128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int tempLen = 0;
                while (numSet.contains(num + tempLen)) {
                    tempLen++;
                }
                maxLength = Math.max(tempLen, maxLength);
            }
        }
        return maxLength;
    }
}
