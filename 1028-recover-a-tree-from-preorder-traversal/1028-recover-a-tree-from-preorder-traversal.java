class Solution {
    private int idx = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal.toCharArray(), 0);
    }

    private TreeNode dfs(char[] chars, int level) {
        // 현재 깊이 확인 (다음 노드가 현재 노드의 자식인지 판별)
        int currLevel = countDashes(chars);
        if (currLevel != level) {
            idx -= currLevel; // 백트래킹 (이전 상태로 복구)
            return null;
        }

        // 숫자 파싱
        int value = parseValue(chars);
        TreeNode node = new TreeNode(value);

        // 왼쪽 자식 탐색 (level + 1)
        node.left = dfs(chars, level + 1);

        // 오른쪽 자식 탐색 (level + 1)
        node.right = dfs(chars, level + 1);

        return node;
    }

    // `-` 개수를 세어 깊이(D) 계산
    private int countDashes(char[] chars) {
        int count = 0;
        while (idx < chars.length && chars[idx] == '-') {
            count++;
            idx++;
        }
        return count;
    }

    // 숫자 파싱하여 정수 값 변환
    private int parseValue(char[] chars) {
        int value = 0;
        while (idx < chars.length && Character.isDigit(chars[idx])) {
            value = value * 10 + (chars[idx] - '0');
            idx++;
        }
        return value;
    }
}