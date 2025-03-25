class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        // 0: 미방문, 1: 방문 중, 2: 방문 완료
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) return false;
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] graph, int[] visited, int node) {
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;

        visited[node] = 1;

        for (int neighbor : graph[node]) {
            if (hasCycle(graph, visited, neighbor)) {
                return true;
            }
        }

        visited[node] = 2;

        return false;
    }
}