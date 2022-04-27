//leetcode 74
public class TDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int l = matrix[0].length-1;

        while( matrix[r][0]<target){
            if(matrix[r][l]>= target){
                break;
            }
            r++;
            if(r == matrix.length){
                return false;
            }
        }

        return search(matrix[r],target);
    }

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}

