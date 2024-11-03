class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize > 0) return false;
        Arrays.sort(hand); //1, 2, 2, 3, 3, 4, 6, 7, 8
        int totalGroup = len/groupSize;
        boolean[] visited = new boolean[hand.length];

        for (int i = 0; i < totalGroup; i++) {
            int j = 0;
            while (visited[j]) j++;
            visited[j] = true;
            if (!backtracking(hand, visited, 1, groupSize, hand[j])) {
                return false;
            }
        }
        return true;
    }

    public boolean backtracking(int[] hand, boolean[] visited, int depth, int groupSize, int prev){
        if (groupSize == depth) {
            return true;
        }

        for (int i = 0; i < hand.length; i++) {
            if (visited[i]) continue;

            if (prev + 1 == hand[i]) {
                visited[i] = true;
                return backtracking(hand, visited, depth + 1, groupSize, hand[i]);
            }
        }

        return false;
    }
}