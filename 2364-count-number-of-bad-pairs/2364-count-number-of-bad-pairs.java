class Solution {
    public long countBadPairs(int[] nums) {
        // 심플한 로직은 이중 루프로 구한다.
        // 시간 복잡도가 올라감
        // hash Table에 index:value 형태로 일단 저장한다?
        // 옳게 된 페어 갯수 먼저 구하기
        long n = nums.length;
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = i - nums[i];
            
            int goodPairsCount = map.getOrDefault(diff, 0);

            count += i - goodPairsCount;

            map.put(diff, goodPairsCount + 1);
        }

        return count;
    }
}