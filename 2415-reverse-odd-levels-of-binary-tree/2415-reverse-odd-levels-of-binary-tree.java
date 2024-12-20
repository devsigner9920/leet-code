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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(TreeNode node1, TreeNode node2, boolean isOdd) {
        if (node1 == null && node2 == null) return;

        if (isOdd) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        dfs(node1.left, node2.right, !isOdd);
        dfs(node1.right, node2.left, !isOdd);
    }
}