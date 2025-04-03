class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i - 1]);
            right[n - 1 - i] = Math.max(right[n - i], nums[n - i]);
        }
        
        long result = 0;

        for (int j = 1; j < n -1; j++) {
            result = Math.max(result, ((long) (left[j] - nums[j]) * right[j]));
        }
        return result;
    }
}