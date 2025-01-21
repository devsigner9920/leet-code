class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int currentL = height[l];
            int currentR = height[r];

            max = Math.max(max, Math.min(currentL, currentR) * (r - l));

            if (height[l] <= height[r]) {
                l++;
                continue;
            }

            if (height[l] > height[r]) {
                r--;
                continue;
            }
        }

        return max;
    }
}