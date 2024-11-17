class Solution {
    public int[][] largestLocal(int[][] grid) {
        var subN = grid.length - 2;
        var subGrid = new int[subN][subN];

        for (int i = 0; i < subN; i++) {
            for (int j = 0; j < subN; j++) {
                subGrid[i][j] = getMax(i, j, grid);
            }
        }

        return subGrid;
    }

    public int getMax(int row, int col, int[][] grid) {
        var max = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                var num = grid[i][j];
                if (max < num) {
                    max = num;
                }
            }
        }

        return max;
    }
}