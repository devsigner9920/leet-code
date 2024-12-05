class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return tryRob(nums, 0);
    }

    // dp(n) = n + Max(dp(n + 2) , dp(n + 3) .. )
    public int tryRob(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (dp[index] > -1) return dp[index];

        int result = Math.max(
            tryRob(nums, index + 1),
            tryRob(nums, index + 2) + nums[index]
        );

        dp[index] = result;

        return result;
    }
}