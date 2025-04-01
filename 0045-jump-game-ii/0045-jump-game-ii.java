class Solution {
    int[] memo;

    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);  // -1은 아직 계산되지 않은 상태

        return dp(nums, 0);
    }

    private int dp(int[] nums, int i) {
        if (i >= nums.length - 1) return 0; // 도착했거나 이미 끝에 도달했으면 0회 점프
        if (nums[i] == 0) return Integer.MAX_VALUE; // 이동 불가

        if (memo[i] != -1) return memo[i];

        int minJumps = Integer.MAX_VALUE;
        for (int k = 1; k <= nums[i]; k++) {
            int next = dp(nums, i + k);
            if (next != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, next + 1);
            }
        }

        memo[i] = minJumps;
        return memo[i];
    }
}