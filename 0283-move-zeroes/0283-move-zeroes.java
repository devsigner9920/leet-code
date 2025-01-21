class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        // 바꿔줄 타겟 0
        int l = 0;
        // 바꿀 대상
        int r = 0;

        while (r < nums.length) {
            int numL = nums[l];
            int numR = nums[r];
            // 만약 l, r 위치에 둘 다 0이면 r 전진한다.
            if (numL == 0 && numR == 0) {
                r++;
                continue;
            }

            // 만약 l 위치에 0이 아니라면 l 전진한다.
            if (numL != 0) {
                l++;
                continue;
            }

            if (numR != 0) {
                nums[l] = numR;
                nums[r] = numL;
            }
        }
    }
}