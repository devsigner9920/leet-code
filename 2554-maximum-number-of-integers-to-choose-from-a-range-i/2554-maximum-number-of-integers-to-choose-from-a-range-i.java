class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        var check = new boolean[banned[banned.length - 1]  + 1];
        for (int i = 0; i < banned.length; i++) {
            check[banned[i]] = true;
        }

        if (maxSum == 1 && check[1]) return 0;

        var sum = 0;
        var count = 0;
        for (int i = 1; i <= n; i++) {
            if (banned[banned.length - 1] >= i) {
                if (check[i]) continue;
            }
            var temp = sum + i;
            if (maxSum >= temp) {
                sum = temp;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}