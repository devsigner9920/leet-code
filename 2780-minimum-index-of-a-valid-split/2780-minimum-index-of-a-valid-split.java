class Solution {
    public int minimumIndex(List<Integer> nums) {
        // 첫번째 배열 맵
        Map<Integer, Integer> n = new HashMap<>();
        // 두번째 배열 맵
        Map<Integer, Integer> m = new HashMap<>();

        for (int num: nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        for (int splitPoint = 0; splitPoint < nums.size(); splitPoint++) {
            int num = nums.get(splitPoint);
            n.put(num, n.getOrDefault(num, 0) + 1);
            m.put(num, m.get(num) - 1);

            if (n.get(num) * 2 > splitPoint + 1 && m.get(num) * 2 > nums.size() - splitPoint - 1) {
                return splitPoint;
            }
        }

        return -1;
    }
}