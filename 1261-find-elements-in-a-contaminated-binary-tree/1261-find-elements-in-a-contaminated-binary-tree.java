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
class FindElements {
    private final Set<Integer> index;
    public FindElements(TreeNode root) {
        this.index = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        root.val = 0;
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            index.add(temp.val);

            if (temp.left != null) {
                temp.left.val = 2 * temp.val + 1;
                que.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.val = 2 * temp.val + 2;
                que.add(temp.right);
            }
        }
    }
    
    public boolean find(int target) {
        return index.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */