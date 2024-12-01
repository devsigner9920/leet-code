class Solution {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] check = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!check[i][j] && grid[i][j] != '0') {
                    findIsland(grid, check, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void findIsland(char[][] grid, boolean[][] check, int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= grid.length || j >= grid[0].length) return;

        if (check[i][j]) return;
        if (grid[i][j] == '0') return;

        check[i][j] = true;

        for (int k = 0; k < 4; k++) {
            findIsland(grid, check, i + dx[k], j + dy[k]);
        }
    }
}