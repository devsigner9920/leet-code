class Solution {
    enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[nums.length - 1] = Index.GOOD;

        return backtrack(nums, 0);
    }

    private boolean backtrack(int[] nums, int position) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        int maxJump = Math.min(position + nums[position], nums.length - 1);
        for (int next = position + 1; next <= maxJump; next++) {
            if (backtrack(nums, next)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }
}