class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(result, 0, new ArrayList<Integer>(), candidates, target);
        return result.stream().distinct().collect(Collectors.toList());
    }

    public void backtracking(List<List<Integer>> result, int start, List<Integer> temp, int[] candidates, int remain) {
        if (remain == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (remain - candidates[i] >= 0) {
                temp.add(candidates[i]);
                backtracking(result, i, temp, candidates, remain - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}