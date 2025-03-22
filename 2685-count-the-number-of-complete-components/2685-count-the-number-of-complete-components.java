class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            System.out.println(123);
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for (int vertex = 0; vertex < n; vertex++) {
            if (visited.contains(vertex)) continue;

            // compInfo[0] = vertices(정점들 vertex 복수형) count, compInfo[1] = total edges count
            int[] compInfo = new int[2];
            dfs(vertex, graph, visited, compInfo);

            if (compInfo[0] * (compInfo[0] - 1) == compInfo[1]) {
                count++;
            }
        }

        return count;
        // List<Integer>[] graph = new List[n];
        // Map<List<Integer>, Integer> componentFreq = new HashMap<>();

        // for (int vertex = 0; vertex < n; vertex++) {
        //     graph[vertex] = new ArrayList<>();
        //     graph[vertex].add(vertex);
        // }

        // for (int[] edge : edges) {
        //     graph[edge[0]].add(edge[1]);
        //     graph[edge[1]].add(edge[0]);
        // }

        // for (int vertex = 0; vertex < n; vertex++) {
        //     List<Integer> neighbors = graph[vertex];
        //     Collections.sort(neighbors);
        //     componentFreq.put(neighbors, componentFreq.getOrDefault(neighbors, 0) + 1);
        // }

        // int completeCount = 0;

        // for (Map.Entry<List<Integer>, Integer> entry : componentFreq.entrySet()) {
        //     if (entry.getKey().size() == entry.getValue()) {
        //         completeCount++;
        //     }
        // }

        // return completeCount;
    }

    private void dfs(int currentVertex, List<Integer>[] graph, Set<Integer> visited, int[] compInfo) {
        visited.add(currentVertex);
        compInfo[0]++; // increment vertex count
        compInfo[1] += graph[currentVertex].size();

        for (int next : graph[currentVertex]) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, compInfo);
            }
        }
    }
}