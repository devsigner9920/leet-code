class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        var special = new boolean[queries.length];
        var violatingIndices = new ArrayList<Integer>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                violatingIndices.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];

            if (isSpecial(query[0] + 1, query[1], violatingIndices)) {
                special[i] = true;
            }
        }

        return special;
    }

    private boolean isSpecial(int start, int end, List<Integer> violatingIndices) {
        var left = 0;
        var right = violatingIndices.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int violatingIndex = violatingIndices.get(mid);

            if (violatingIndex < start) {
                left = mid + 1;
            } else if (violatingIndex > end) {
                right = mid - 1;
            } else {
                return false;
            }
        }

        return true;
    }
}