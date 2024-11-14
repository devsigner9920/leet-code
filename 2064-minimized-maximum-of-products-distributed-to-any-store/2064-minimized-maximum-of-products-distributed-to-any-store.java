class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // n개의 지점에다가 배분해야 함
        // 최대한 양을 적게 해서 배분해야 함
        // 이진 탐색으로 상품을 모든 저장소에 분배한다.

        // 탐색 범위는 left = 1, right = 100000 10^5까지
        // right = max(quantities) 로 쓸 수도 있다. (크게 차이 없음)
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int productQuantity: quantities) {
                // mid 만큼 나눠주면 최대 몇개까지 각 상품에 배정해줄 수 있는지 알 수 있다.
                // ex) 10 / 3 -> 3.3 -> 4 
                //     즉 3, 3, 3, 1 이렇게 4개로 분배해줄 수 있단 뜻
                sum += (productQuantity + mid - 1) / mid;
            }

            // sum 값이 n 보다 크다면, 분배를 제대로 할 수 없단 뜻이다.
            // 그러므로 left을 늘려서 각 지점이 받을 수 있는 최대 상품 갯수를 늘려준다.
            if (sum > n) {
                left = mid + 1;
            } else {
                // sum이 n보다 작거나 같다면 현재의 mid 값으로 상품을 나눌 수 있다는 의미입니다.
                // 이 경우 right를 mid로 줄여 더 작은 값으로 나눌 수 있는지 확인합니다.
                right = mid;
            }
        }
        return left;
    }
}