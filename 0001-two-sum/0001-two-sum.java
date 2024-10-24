class Solution {
    public int[] twoSum(int[] nums, int target) {
        // num, index
        var hashTable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var calcNum = target - nums[i];
            
            if (hashTable.containsKey(calcNum)) {
                return new int[]{i, hashTable.get(calcNum)};
            }
            hashTable.put(nums[i], i);
        }

        return new int[2];
    }
}