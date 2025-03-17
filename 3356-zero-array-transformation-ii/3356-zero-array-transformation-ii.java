class Solution {
    int[][] prefixSum;
    public int minZeroArray(int[] nums, int[][] queries) {
        prefixSum = new int[queries.length][nums.length];

        int left = 0;
        int right = queries.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canZero(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left == queries.length) return -1;

        return left;
    }

    public boolean canZero(int[] nums, int[][] queries, int k) {
        int[] prefix = new int[nums.length];

        for (int i = 0; i < k; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];

            for (int j = start; j <= end; j++) {
                prefix[j] += val;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > prefix[i]) {
                return false;
            }
        }

        return true;
    }
}