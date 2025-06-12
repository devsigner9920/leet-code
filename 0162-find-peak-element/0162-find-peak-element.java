class Solution {
    public int findPeakElement(int[] nums) {
        // 우상향
        // 우하향
        // 봉우리

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) return i;
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return 0;
    }
}