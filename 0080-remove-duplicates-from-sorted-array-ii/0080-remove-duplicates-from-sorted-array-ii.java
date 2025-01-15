class Solution {
    public int removeDuplicates(int[] nums) {
        int inc = 1;
        int sameCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                sameCount++;
            } else {
                sameCount = 1;
            }

            if (sameCount <= 2) {
                nums[inc++] = nums[i];
            }
        }

        return inc;
    }
}