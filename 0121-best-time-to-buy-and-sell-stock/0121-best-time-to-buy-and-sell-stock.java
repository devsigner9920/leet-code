class Solution {
    public int maxProfit(int[] prices) {
        var range = prices.length - 1;
        var profit = 0;

        while (range > 0) {
            var left = 0;
            var right = range;

            while (right < prices.length) {
                profit = Math.max(profit, prices[right] - prices[left]);

                left++;
                right++;
            }

            range--;
        }

        return profit;
    }
}