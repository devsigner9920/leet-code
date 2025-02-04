class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }

            max = Math.max(max, cur);
        }

        return max;
    }
}