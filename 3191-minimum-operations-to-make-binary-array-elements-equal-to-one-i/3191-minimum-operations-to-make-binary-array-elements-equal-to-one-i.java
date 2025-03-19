class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int sum = 0;

        for (int num: nums) {
            if (num == 1) {
                sum++;
            }
        }

        if (sum == nums.length) return 0;

        for (int left = 0, right = left + 3; right <= nums.length; left++, right++) {
            if (nums[left] != 0) continue;

            for (int j = left; j < right; j++) {
                if (nums[j] == 0) {
                    nums[j] = 1;
                    sum++;
                } else {
                    nums[j] = 0;
                    sum--;
                }
            }
            count++;
            if (sum == nums.length) {
                return count;
            }
        }

        return -1;
    }
}