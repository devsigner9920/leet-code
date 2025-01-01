class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int[] set = new int[nums.length];
        set[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (set[k - 1] != nums[i]) {
                set[k++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = set[i];
        }

        return k;
    }
}