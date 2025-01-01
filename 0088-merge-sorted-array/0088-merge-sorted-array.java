class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            int nums2Idx = 0;
            for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[nums2Idx++];
            }
        }

        Arrays.sort(nums1);
    }
}