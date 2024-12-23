class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int totalSwaps = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            // 현재 레벨의 값을 리스트에 추가
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // 최소 스왑 계산
            totalSwaps += calculateMinSwaps(levelValues);
        }

        return totalSwaps;
    }

    private int calculateMinSwaps(List<Integer> values) {
        // 값과 원래 인덱스를 함께 정렬하기 위해 Map 형태로 변환
        int n = values.size();
        List<int[]> indexedValues = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexedValues.add(new int[]{values.get(i), i});
        }

        // 값 기준으로 정렬
        indexedValues.sort((a, b) -> Integer.compare(a[0], b[0]));

        // 사이클 계산을 통해 최소 스왑 수 구하기
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // 이미 방문했거나 올바른 위치에 있는 경우 건너뛰기
            if (visited[i] || indexedValues.get(i)[1] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexedValues.get(j)[1];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}