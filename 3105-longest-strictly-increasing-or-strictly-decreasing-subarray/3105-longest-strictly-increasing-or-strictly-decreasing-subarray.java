class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int result = 0;

        int inc = 1;
        int dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
            } else {
                inc = 1;
            }

            if (nums[i] < nums[i - 1]) {
                dec++;
            } else {
                dec = 1;
            }

            result = Math.max(result, Math.max(inc, dec));
        }
        
        return result;
    }
}