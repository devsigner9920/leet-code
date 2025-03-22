class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int longStreak = 1;
        
        for (int num: set) {
            if (set.contains(num - 1)) continue;

            int current = num;
            int streak = 1;
            while (set.contains(current + 1)) {
                current++;
                streak++;
            }

            longStreak = Math.max(longStreak, streak);
        }

        return longStreak;
    }
}