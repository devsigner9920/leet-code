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
    int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode node = new TreeNode();
        dfs(node, traversal.toCharArray(), 0);

        return node;
    }

    private void dfs(TreeNode node, char[] chars, int level) {
        if (node == null) return;

        int value = 0;
        while (idx < chars.length && Character.isDigit(chars[idx])) {
            value = value * 10 + (chars[idx] - '0');
            idx++;
        }
        idx--;
        node.val = value;

        int nextLevel = 0;

        for (int i = idx + 1; i < chars.length; i++) {
            if (chars[i] == '-') {
                nextLevel++;
            } else {
                break;
            }
        }

        if (nextLevel != level + 1) {
            return;
        }

        idx += nextLevel + 1;

        node.left = new TreeNode();

        dfs(node.left, chars, nextLevel);

        nextLevel = 0;

        for (int i = idx + 1; i < chars.length; i++) {
            if (chars[i] == '-') {
                nextLevel++;
            } else {
                break;
            }
        }

        if (nextLevel != level + 1) {
            return;
        }

        idx += nextLevel + 1;

        node.right = new TreeNode();

        dfs(node.right, chars, nextLevel);
    }
}