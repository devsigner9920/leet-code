class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] memo = new int[values.length + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        
        int result = 0;
        for (int i = values.length - 1; i > 0; i--) {
            memo[i] = Math.max(values[i] - i, memo[i + 1]);
            System.out.println(i + "idx: " + memo[i]);
        }

        for (int i = 0; i < values.length - 1; i++) {
            result = Math.max(values[i] + i + memo[i + 1], result);
        }


        // 8, 0, 3, -1, 2
        //    dp[1] 번째의 max = 3
        //    dp[2] 번째의 max = 3
        //    dp[3] 번째의 max = 2
        //    dp[4] 번째의 max = 2 <- 본인

        // 0 idx + dp[1]

        return result;
    }
}