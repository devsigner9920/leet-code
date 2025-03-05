class Solution {
    public long coloredCells(int n) {
        if (n == 1) {
            return 1L;
        }

        long result = 0;
        long start = 0;

        for (int i = 2; i <= n; i++) {
            start += 4;
            result += start;
        }

        return result + 1;
    }
}