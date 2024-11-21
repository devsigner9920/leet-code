class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        var a = new int[n + 1];
        a[0] = a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 2] + a[i - 1];
        }

        return a[n];
    }
}