public class InvertBinTree {


    public static void main(String[] args) {

    }

    //leetcode 543
    public int diameterOfBinaryTree(TreeNode root) {
        int[] a = new int[]{0};
        return dfs(root,a);
    }

    int dfs(TreeNode root, int[] a) {
        if (root == null)
            return -1;
        int l = dfs(root.left, a);
        int r = dfs(root.right, a);
        a[0] = Math.max(a[0], 2 + l + r);
        return 1 + Math.max(l, r);
    }


    //leetcode 104
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int ld = maxDepth(root.left) + 1;
        int rd = maxDepth(root.right) + 1;
        if (ld > rd)
            return ld;
        return rd;
    }

    //    leetcode 226
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
