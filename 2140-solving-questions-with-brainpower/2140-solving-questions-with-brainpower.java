class Solution {
    long[] memo;
    public long mostPoints(int[][] questions) {
        memo = new long[questions.length];

        return solve(questions, 0);
    }

    private long solve(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }

        if (memo[i] != 0) return memo[i];

        long a = questions[i][0] + solve(questions, i + questions[i][1] + 1);
        long b = solve(questions, i + 1);
        memo[i] = Math.max(a, b);
        return memo[i];
    }
}