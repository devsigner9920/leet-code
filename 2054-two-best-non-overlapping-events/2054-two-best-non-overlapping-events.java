class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d: dp) Arrays.fill(d, -1);

        return findEvents(events, 0, 0, dp);
    }

    private int findEvents(int[][] events, int index, int count, int[][] dp) {
        if (count == 2 || index >= events.length) return 0;

        if (dp[index][count] == -1) {
            int end = events[index][1];

            int low = index + 1;
            int high = events.length - 1;

            while (low < high) {
                int mid = low + ((high - low) >> 1);

                if (events[mid][0] > end) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int include = events[index][2] + 
                ((low < events.length && events[low][0] > end) ? findEvents(events, low, count + 1, dp) : 0);
            int exclude = findEvents(events, index + 1, count, dp);
            dp[index][count] = Math.max(include, exclude);
        }

        return dp[index][count];
    }
}