class Solution {
    public int maximumBeauty(int[] nums, int k) {
        var max = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            var upperbound = findUpperbound(nums, nums[i] + 2 * k);

            max = Math.max(max, upperbound - i + 1);
        }

        return max;
    }

    private int findUpperbound(int[] nums, int curMaxValue) {
        var left = 0;
        var right = nums.length - 1;
        var result = 0;

        while (left <= right) {
            // mid == index 구하는 과정
            var mid = left + (right - left) / 2;

            if (nums[mid] <= curMaxValue) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}