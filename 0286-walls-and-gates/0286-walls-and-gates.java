class Solution {
    int[] x = new int[] {-1, 1, 0, 0};
    int[] y = new int[] {0, 0, 1, -1};
    int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] ==0) {
                    queue.offer(new int[] {i, j});
                    }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            int m = pos[0];
            int n = pos[1];

            for (int i = 0; i < 4; i++) {
                int xm = m + x[i];
                int yn = n + y[i];
                if (xm < 0 || yn < 0 || xm >= rooms.length || yn >= rooms[0].length || rooms[xm][yn] != INF) continue;
                rooms[xm][yn] = rooms[m][n] + 1;
                queue.offer(new int[] {xm, yn});
            }
        }
    }
}