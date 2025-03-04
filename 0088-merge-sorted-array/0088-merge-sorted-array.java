class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // n이 0이면 어차피 sort 되어 있어서 작업할 부분이 없음
        if (n == 0) {
            return;
        }

        // nums1에서 m개의 element를 복사해 새로운 배열 생성
        // 1번 예제) [1, 2, 3]
        int[] nums1Copy = Arrays.copyOf(nums1, m);

        // nums1Copy 배열의 인덱스
        int n1Pointer = 0;
        // nums2 배열의 인덱스
        int n2Pointer = 0;

        for (int i = 0; i < nums1.length; i++) {
            // 만약 n1Pointer가 m을 초과하면 IndexOutOfRange 에러가 반환되므로 바운더리 생성
            // 만약 nums1Copy가 현재 위치한 인덱스(n1Pointer)의 엘리먼트가 더 작거나 같으면 현재 위치의 nums1에 추가
            if (n2Pointer >= n || (n1Pointer < m && nums1Copy[n1Pointer] < nums2[n2Pointer])) {
                nums1[i] = nums1Copy[n1Pointer++];
            } else {
                // 반대 케이스에 대해서는 nums2의 엘리먼트를 nums1에 넣어주고 n2Pointer 증가 시키기
                nums1[i] = nums2[n2Pointer++];
            }
        }

    }
}