class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxExtent = 0;

        while (left < right) {
            maxExtent = Math.max(maxExtent, (right - left) * Math.min(height[left], height[right]));
            
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxExtent;
    }
}