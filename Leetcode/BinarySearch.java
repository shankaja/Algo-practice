//leetcode 704
public class BinarySearch {
    public static void main(String[] args) {
        int idx = search(new int[]{
                1, 2, 4, 5, 6, 8, 12, 17, 19, 22}, 1);
        System.out.println(idx);
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }


}
