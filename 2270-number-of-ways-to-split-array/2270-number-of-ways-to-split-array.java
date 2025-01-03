class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num: nums) {
            sum += num;
        }
        long current = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            current += nums[i];
            sum -= nums[i];

            if (current >= sum) {
                count++;
            }
        }

        return count;
    }
}