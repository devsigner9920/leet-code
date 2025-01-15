class Solution {
    public int maxProfit(int[] prices) {
        var minPrice = prices[0];
        var maxPrice = 0;

        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }

            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
        }

        return maxPrice;
    }
}