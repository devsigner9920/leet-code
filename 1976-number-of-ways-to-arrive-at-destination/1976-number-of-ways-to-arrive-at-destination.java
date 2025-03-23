class Solution {
    private int shortestPath = Integer.MAX_VALUE;
    private static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int vertex1 = roads[i][0];
            int vertex2 = roads[i][1];
            int weight = roads[i][2];

            graph[vertex1].add(new int[]{vertex2, weight});
            graph[vertex2].add(new int[]{vertex1, weight});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        pq.offer(new long[]{0, 0}); // distance, vertex

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long curDist = curr[0];
            int u = (int) curr[1];

            if (curDist > dist[u]) continue;

            for (int[] edge: graph[u]) {
                int v = edge[0];
                int weight = edge[1];

                long newDist = curDist + weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}