class Solution {
    public int maxProfit(int[] prices) {
        int[] memo = new int[prices.length];

        memo[prices.length - 1] = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            memo[i] = Math.max(memo[i + 1], prices[i]);
        }

        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            result = Math.max(memo[i] - prices[i], result);
        }

        return result;
    }
}