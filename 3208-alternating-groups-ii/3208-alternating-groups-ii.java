class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int alterCount = 1;
        int lastColor = colors[0];

        int result = 0;

        for (int i = 1; i < n + k - 1; i++) {
            int idx = i % n;

            if (colors[idx] == lastColor) {
                alterCount = 1;
                lastColor = colors[idx];
                continue;
            }

            alterCount += 1;

            if (alterCount >= k) {
                result++;
            }

            lastColor = colors[idx];
        }

        return result;
    }
}