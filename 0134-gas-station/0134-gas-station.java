class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currain = 0;
        int totalGain = 0;
        int answer = 0;

        for (int i = 0; i < gas.length; ++i) {
            totalGain += gas[i] - cost[i];
            currain += gas[i] - cost[i];

            if (currain < 0) {
                answer = i + 1;
                currain = 0;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }
}