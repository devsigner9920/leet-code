class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (k > nums[i]) return -1;

            if (k == nums[i]) continue;

            set.add(nums[i]);
        }

        return set.size();
    }
}