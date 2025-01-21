class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) continue;

            int j = i;
            while (j != nums.length - 1) {
                if (nums[j + 1] == 0) break;
                nums[j] = nums[j + 1];
                nums[j + 1] = 0;
                j++;
            }
        }
    }
}