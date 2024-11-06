class Solution {
    public int findMin(int[] nums) {
        // 2, 4, 5, 6, 7, 0, 1
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

            if (left == right) {
                return nums[left];
            }
        }

        return nums[left];
    }
}