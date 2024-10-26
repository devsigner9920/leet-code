class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i!=0 && nums[i-1]==nums[i]) continue;
            var set = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                var complement = -(nums[i] + nums[j]);

                if (set.contains(complement)) {
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                }
                set.add(nums[j]);
            }
        }

        return result.stream().distinct().toList();
    }
}