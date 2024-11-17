/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var temp = q.poll();
                if (temp != null) {
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            if (!q.isEmpty()) count++;
        }
        return count;
    }
}