class Solution {
    public int maximumCandies(int[] candies, long k) {
        if (k == 0) return 0;
        int result = 0;
        int left = 1;
        int right = Arrays.stream(candies).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public boolean canDistribute(int[] candies, long k, int x) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i] / x;

            if (count >= k) return true;
        }

        return false;
    }
}