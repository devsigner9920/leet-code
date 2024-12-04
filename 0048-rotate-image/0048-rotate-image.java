class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                var temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                var temp = matrix[i][j];
                var reverseTarget = matrix.length - 1 - j;
                matrix[i][j] = matrix[i][reverseTarget];
                matrix[i][reverseTarget] = temp;
            }
        }
    }
}