/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        var que = new LinkedList<TreeNode>();
        var sb = new StringBuffer();
        que.add(root);
        while (!que.isEmpty()) {
            var node = que.poll();
            
            if (node != null) {
                sb.append(node.val);
                que.add(node.left);
                que.add(node.right);
            } else {
                sb.append("null");
            }

            if (!que.isEmpty()) {
                sb.append(",");
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        var arr = data.split(",");
        var que = new LinkedList<TreeNode>();
        var root = new TreeNode(Integer.parseInt(arr[0]));
        que.add(root);

        for (int i = 1; i < arr.length; i++) {
            var temp = que.poll();
            TreeNode left;
            if (arr[i].equals("null")) {
                left = null;
            } else {
                left = new TreeNode(Integer.parseInt(arr[i]));
                temp.left = left;
                que.add(temp.left);
            }

            i++;
            TreeNode right;
            if (arr[i].equals("null")) {
                right = null;
            } else {
                right = new TreeNode(Integer.parseInt(arr[i]));
                temp.right = right;
                que.add(temp.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));