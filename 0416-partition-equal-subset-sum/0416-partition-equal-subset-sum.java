class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;

        int answer = sum / 2;

        boolean[] dp = new boolean[answer + 1];
        dp[0] = true;

        for (int num: nums) {
            for (int target = answer; target >= num; target--) {
                dp[target] = dp[target] || dp[target - num];
            }
        }

        return dp[answer];
    }
}