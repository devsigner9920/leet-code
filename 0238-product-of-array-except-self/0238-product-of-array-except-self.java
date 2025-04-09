class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = 1;
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i] * r;
            r *= nums[i];
        }

        return sum;
    }
}