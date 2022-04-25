import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] r = new int[l];

        r[0] = nums[0];
        for (int i = 1; i < l; i++) {
            r[i] = nums[i] * r[i - 1];
        }

        for (int i = l - 2; i >= 0; i--) {
            nums[i] = nums[i + 1] * nums[i];
        }

        r[l-1] = r[l-2];
        for (int i = l-2; i >0; i--) {
            r[i] = r[i-1]*nums[i+1];
        }
        r[0] = nums[1];

        return r;
    }
}
