
class Solution {

    private class TreeNode {
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

    int result;

    public int minCameraCover(TreeNode root) {
        result = 0;
        if (traversal(root) == 0)
            result++;
        return result;
    }

    private int traversal(TreeNode node) {
        if (node == null)
            return 2;
        int left = traversal(node.left);
        int right = traversal(node.right);
        if (left == 2 && right == 2)
            return 0;
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        ;
        return 2;
    }
}