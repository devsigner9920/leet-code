class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int count = 0;
        int idx = 0;
        int lastPos = nums.length - 1;

        while (idx <= lastPos) {
            if (nums[idx] == val) {
                count++;
                nums[idx] = nums[lastPos];
                lastPos--;
            } else {
                idx++;
            }
        }

        return nums.length - count;
    }
}