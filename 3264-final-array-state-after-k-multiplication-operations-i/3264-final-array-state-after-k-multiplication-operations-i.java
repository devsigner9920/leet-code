class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // index, value
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int result = a[1] - b[1];
            if (result == 0) {
                result = a[0] - b[0];
            }

            return result;
        });

        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
        }

        while (k != 0) {
            var arr = queue.poll();

            nums[arr[0]] = arr[1] * multiplier;
            queue.add(new int[]{arr[0], nums[arr[0]]});

            k--;
        }
        
        return nums;
    }
}