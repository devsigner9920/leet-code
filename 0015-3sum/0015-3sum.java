class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 하나를 먼저 고르고 그 다음에 오는 두개의 타겟은 투 포인터로 해결함
        // two-pointer 는 정렬된 배열에서 특정 조건을 찾는게 수월함
        // 특히나 정렬되어 있으면 two sum 을 찾기 더 수월하기 때문

        // 수가 정렬되지 않아 있으므로 정렬 시킴
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        // nums 에서 하나를 고르는 작업을 함
        // two sum 을 찾기 위해서는 left는 1부터 시작, right는 nums.length - 1부터 시작한다
        // target 은 nums[i]이 만약에 -1 이면 1이 타겟 데이터가 된다.
        // 다음에 오는 수가 0과 2라고 한다면 더하면 타겟보다 크기 때문에 right--
        // 만약에 타겟보다 수가 작다면 left++
        for (int i = 0; i < nums.length - 2; i++) {
            // 중복되는 첫 번째 숫자는 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 0 = target + something
            // -target = something
            int target = nums[i] * -1;

            var left = i + 1;
            var right = nums.length - 1;

            while (left < right) {
                // left + right == target 이면 result add 및 break
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                     // 중복 방지를 위해 left, right 이동
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // 다음에 또 정합성이 맞는 로직이 올 수 있기 때문에 증분과 감소
                    left++;
                    right--;
                    continue;
                }

                // left + right > target 이면 right--
                if (nums[left] + nums[right] > target) {
                    right--;
                    continue;
                }

                // left + right < target 이면 left++
                if (nums[left] + nums[right] < target) {
                    left++;
                    continue;
                }
            }
        }
        

        return result;
    }
}