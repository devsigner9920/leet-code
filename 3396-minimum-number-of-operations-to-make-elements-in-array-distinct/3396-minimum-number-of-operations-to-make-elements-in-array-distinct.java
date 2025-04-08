class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i += 3) {
            if (isUnique(i, nums)) {
                return count;
            }
            
            count++;
        }

        return count;
    }

    private boolean isUnique(int pos, int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = pos; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return set.size() == nums.length - pos;
    }
}