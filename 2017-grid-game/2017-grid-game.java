class Solution {
    public long gridGame(int[][] grid) {
        int c = grid[0].length;
        long[] upPrefixSum = new long[c];
        long[] downPrefixSum = new long[c];
        long minValue = Long.MAX_VALUE;

        // 1. Prefix Sum 계산
        for (int i = 0; i < c; i++) {
            if (i == 0) {
                upPrefixSum[i] = grid[0][i];
                downPrefixSum[i] = grid[1][i];
            } else {
                upPrefixSum[i] = upPrefixSum[i - 1] + grid[0][i];
                downPrefixSum[i] = downPrefixSum[i - 1] + grid[1][i];
            }
        }

        // 2. 순회하며 계산
        for (int i = 0; i < c; i++) {
            if (i == 0) {
                minValue = upPrefixSum[c - 1] - grid[0][0];
                continue;
            }

            // 첫번째 칸에 누계
            long up = upPrefixSum[c - 1] - upPrefixSum[i];
            // 두번째 칸에 누계
            long down = downPrefixSum[i - 1];

            long result = Math.max(up, down);

            minValue = Math.min(result, minValue);
        }

        return minValue;
    }
}