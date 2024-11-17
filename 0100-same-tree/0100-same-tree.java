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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var q1 = new LinkedList<TreeNode>();
        var q2 = new LinkedList<TreeNode>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            var temp1 = q1.poll();
            var temp2 = q2.poll();

            if (temp1 != null && temp2 != null) {
                if (temp1.val != temp2.val) {
                    return false;
                }
            } else if (temp1 == null && temp2 == null) {
                continue;
            } else {
                return false;
            }

            q1.add(temp1.left);
            q1.add(temp1.right);
            q2.add(temp2.left);
            q2.add(temp2.right);
        }

        return true;
    }
}