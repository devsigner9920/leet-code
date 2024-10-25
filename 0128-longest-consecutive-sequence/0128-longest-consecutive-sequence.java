class Solution {
    public int longestConsecutive(int[] nums) {
        nums = Arrays.stream(nums).distinct().sorted().toArray();

        if (nums.length == 0) {
            return 0;
        }

        int idx = 1;
        int count = 1;
        int maxCount = 1;

        while (idx < nums.length) {
            if (nums[idx] - 1 == nums[idx - 1]) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 1;
            }

            idx++;
        }

        return maxCount;
    }
}