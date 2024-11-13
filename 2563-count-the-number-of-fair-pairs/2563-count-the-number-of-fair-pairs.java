class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            var low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            var up = upperBound(nums, i + 1, nums.length, upper - nums[i]);

            count += up - low;
        }

        return count;
    }

    public int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    public int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) end = mid;
            else start = mid + 1;
        }

        return start;
    }
}