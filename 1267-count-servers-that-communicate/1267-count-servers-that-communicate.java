class Solution {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    public int countServers(int[][] grid) {
        // 1: 서버 O, 0: 서버 X

        Queue<int[]> que = new LinkedList<>();
        // 서버 위치 인덱싱
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    que.add(new int[]{i, j});
                }
            }
        }

        int count = 0;
        // 만약 떨어져 있더라도 같은 row or col 에 존재한다면 연결되어 있는거임
        while (!que.isEmpty()) {
            int[] server = que.poll();
            
            for (int i = 0; i < dx.length; i++) {
                int x = server[0];
                int y = server[1];

                x += dx[i];
                y += dy[i];

                boolean isConnect = false;
                while(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    if (grid[x][y] == 1) {
                        isConnect = true;
                        break;
                    }

                    x += dx[i];
                    y += dy[i];
                }
                

                if (isConnect) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}