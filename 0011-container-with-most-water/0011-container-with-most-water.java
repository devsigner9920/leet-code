class Solution {
    public int maxArea(int[] height) {
        // height는 물을 막는 막대기의 길이를 가지고 있다.
        // 1,8,6,2,5,4,8,3,7 이라면 9개의 막대기가 있다.
        // 먼저 two pointer를 활용한다.
        // two pointer 전략은 left 0, right height.length - 1부터 시작한다.
        // x가 길고 y가 길수록 유리하다.
        // maxArea = 0 으로 두고, 구한 값과 비교를 하여 Math.max로 비교한다.
        // 각 포인터에서 최고 높이는 제일 작은 수가 최고 높이가 된다.

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            var h = Math.min(height[left], height[right]);
            var w = right - left;

            maxArea = Math.max(maxArea, h * w);
            // 만약에 왼쪽 작대기가 더 작으면 한칸 더 이동시켜서 비교시킨다. width가 1 빠진거보다 이동시킨 작대기가 더 크면 이득이기 때문
            if (height[left] <= height[right]) {
                left++;
                continue;
            }
            // 마찬가지다.
            if (height[left] > height[right]) {
                right--;
                continue;
            }
        }

        return maxArea;
    }
}