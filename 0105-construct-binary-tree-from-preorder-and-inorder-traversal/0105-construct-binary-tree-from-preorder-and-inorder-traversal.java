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
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // inorder: left -> root -> right
        // preorder: root -> left -> right
        var root = makeTree(preorder, 0, preorder.length - 1, inorderMap);
    
        return root;
    }

    private TreeNode makeTree(int[] preorder, int left, int right, Map<Integer, Integer> inorderMap) {
        if (left > right) return null;

        var root = new TreeNode(preorder[preorderIndex++]);

        root.left = makeTree(preorder, left, inorderMap.get(root.val) - 1, inorderMap);

        root.right = makeTree(preorder, inorderMap.get(root.val) + 1, right, inorderMap);

        return root;
    }
}


/*
public TreeNode buildTree(int[] preorder, int[] inorder) {
        // inorder: left -> root -> right
        // preorder: root -> left -> right

        // key: inorder 의 value, value: inorder의 index
        var inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i< inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        var root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    
        return root;
    }
    // preorder 배열, preorder 스타트 포인트, preorder 엔드포인트, inorder 배열, inorder 스타트포인트, inorder 엔드포인트, inorder 맵
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // preStart가 preEnd 보다 크거나 inStart가 inEnd 보다 클 때 null 반환
        // 즉, 범위를 벗어난거면 더이상 자식 노드가 없다는 뜻
        if (preStart > preEnd || inStart > inEnd) return null;

        // root 설정
        // 최초에는 preorder 가 root 가 0번째니까 preorder Start 포인트부터 세팅
        var root = new TreeNode(preorder[preStart]);

        // inorder 의 루트는 map 에서 현재 preorder로 세팅된 val 로 인덱스 가져올 수 있음
        var inRoot = inMap.get(root.val);

        // 1 - 0 = 1
        var numsLeft = inRoot - inStart;

        // preStart + 1해주면 왼쪽으로 가서 시작함
        // preStart + numsLeft 해주면 어디서 끝내야 하는지 알 수 있음
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
*/