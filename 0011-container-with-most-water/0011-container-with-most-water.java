class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int leftH = height[left];
            int rightH = height[right];

            max = Math.max(max, Math.min(leftH, rightH) * (right - left));

            if (leftH < rightH) left++;
            else right--;
        }

        return max;
    }
}