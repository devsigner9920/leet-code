class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return map.entrySet().stream().filter(entrySet -> entrySet.getValue() > nums.length / 2).findAny().get().getKey();
    }
}