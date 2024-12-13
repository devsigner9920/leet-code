class Solution {
    public long findScore(int[] nums) {
        var map = new TreeMap<Integer, List<Integer>>();
        var check = new boolean[nums.length];
        var score = 0L;

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()) // 키가 없으면 새로운 리스트 생성
                .add(i); // 인덱스 추가
        }

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            var indexList = entry.getValue();

            for (int index: indexList) {
                if (check[index]) continue;

                score += nums[index];

                if (index - 1 >= 0) check[index - 1] = true;
                check[index] = true;
                if (index + 1 < nums.length) check[index + 1] = true;
            }
        }

        return score;
    }
}