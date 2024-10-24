class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // num, count
        var map = new HashMap<Integer, Integer>();

        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                continue;
            }

            map.put(num, -1);
        }

        return map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).mapToInt(Map.Entry::getKey).limit(k).toArray();
    }
}