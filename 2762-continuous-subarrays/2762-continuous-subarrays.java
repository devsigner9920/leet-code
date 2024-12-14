class Solution {
    public long continuousSubarrays(int[] nums) {
        // 슬라이딩 윈도우 쓰기
        var freq = new TreeMap<Integer, Integer>();
        var left = 0;
        var right = 0;
        var n = nums.length;
        var count = 0L;

        while (right < n) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                freq.put(nums[left], freq.get(nums[left]) - 1);

                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }

                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}