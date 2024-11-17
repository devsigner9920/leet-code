class Solution {
    public int[] findColumnWidth(int[][] grid) {
        var m = grid.length;
        var n = grid[0].length;

        var arr = new int[n];

        for (int i = 0; i < n; i++) {
            var temp = -1000000001;
            for (int j = 0; j < m; j++) {
                temp = Math.max(temp, (grid[j][i] + "").length());
            }
            arr[i] = temp;
        }

        return arr;
    }
}