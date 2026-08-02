/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int maxSum = 0;

    class NodeInfo {
        boolean isBST;
        int min;
        int max;
        int sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private NodeInfo dfs(TreeNode node) {

        if (node == null) {
            return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);

        if (left.isBST && right.isBST &&
            node.val > left.max &&
            node.val < right.min) {

            int sum = left.sum + right.sum + node.val;
            maxSum = Math.max(maxSum, sum);

            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return new NodeInfo(true, min, max, sum);
        }

        return new NodeInfo(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}