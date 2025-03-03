class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int pivotCount = 0;
        Queue<Integer> front = new LinkedList<>();
        Queue<Integer> back = new LinkedList<>();

        for (int num: nums) {
            if (num < pivot) {
                front.add(num);
            } else if (num > pivot) {
                back.add(num);
            } else {
                pivotCount++;
            }
        }


        int idx = 0;
        while (!front.isEmpty()) {
            nums[idx++] = front.poll();
        }
        while (pivotCount != 0) {
            nums[idx++] = pivot;
            pivotCount--;
        }
        while (!back.isEmpty()) {
            nums[idx++] = back.poll();
        }

        return nums;
    }
}