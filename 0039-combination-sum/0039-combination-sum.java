class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(result, 0, new ArrayList<Integer>(), candidates, target);
        return result.stream().distinct().collect(Collectors.toList());
    }

    public void backtracking(List<List<Integer>> result, int start, List<Integer> temp, int[] candidates, int target) {
        var res = temp.stream().mapToInt(Integer::intValue).sum();
        if (res > target) {
            return;
        }

        if (res == target) {
            var integers = new ArrayList<>(temp).stream().sorted().collect(Collectors.toList());
            result.add(integers);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtracking(result, i, temp, candidates, target);
             temp.remove(temp.size() - 1);
        }
    }
}