class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean pass = true;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] + nums[i]) % 2 == 0) {
                return false;
            }
        }

        return pass;
    }
}