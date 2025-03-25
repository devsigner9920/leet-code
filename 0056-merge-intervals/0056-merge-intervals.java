class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int[]> list = new ArrayList<>();

        int left = 0;
        int right = 1;

        while (right < intervals.length) {
            if (intervals[left][1] >= intervals[right][0]) {
                intervals[left] = new int[]{
                    intervals[left][0],
                    Math.max(intervals[left][1], intervals[right][1])
                };
                right++;
            } else {
                list.add(intervals[left]);
                left = right;
                right = left + 1;
            }
        }

        // 마지막 interval 처리
        list.add(intervals[left]);

        return list.toArray(new int[list.size()][]);
    }
}