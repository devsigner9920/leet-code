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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        var q = new LinkedList<TreeNode>();
        q.add(root);
        
        while (!q.isEmpty()) {
            var size = q.size();
            var subList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var temp = q.pop();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                subList.add(temp.val);
            }
            list.add(subList);
        }

        return list;
    }
}