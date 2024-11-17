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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        var q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            var temp = q.remove();
            var r = temp.right;
            temp.right = temp.left;
            temp.left = r;
            if (temp.left != null) {
                q.add(temp.left);
                
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        return root;
    }
}