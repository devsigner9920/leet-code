class Solution {
    public int maximumCount(int[] nums) {
        int zeroCount = 0;
        int i;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            if (nums[i] > 0) {
                break;
            }
        }

        return Math.max(nums.length - i, i - zeroCount);
    }
}