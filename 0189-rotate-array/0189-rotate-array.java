class Solution {
    public void rotate(int[] nums, int k) {
        int rotateCount = k % nums.length;

        if (rotateCount == 0) return;
        System.out.println(rotateCount);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotateCount - 1);
        reverse(nums, rotateCount, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}