class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] cash = new int[n];
        int[] hold = new int[n];

        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            System.out.println(i + "번째 cash: " + cash[i] + ", hold: " + hold[i]);
        }

        return cash[n - 1];
    }
}