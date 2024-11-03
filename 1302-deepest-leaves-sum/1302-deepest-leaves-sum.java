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
    public int deepestLeavesSum(TreeNode root) {
        var arr = new int[5000];
        dfs(root, 0, arr);

        var answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) break;
            answer = arr[i];
        }

        return answer;
    }

    public void dfs(TreeNode tree, int depth, int[] arr) {
        if (tree == null) {
            return;
        }
        arr[depth] += tree.val;
        if (tree.left == null && tree.right == null) {
            return;
        }
        dfs(tree.left, depth + 1, arr);
        dfs(tree.right, depth + 1, arr);
    }
}