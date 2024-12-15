class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        return greedy(classes, extraStudents, 0);
    }

    private double greedy(int[][] classes, int extraStudents, int index) {
        if (index == classes.length) return -1f;
        if (extraStudents == 0) {
            double result = 0f;
            for (int[] clazz: classes) {
                double temp = (double) clazz[0] / (double) clazz[1];
                result += temp;
            }
            return result / classes.length;
        }

        classes[index][0] += 1;
        classes[index][1] += 1;
        var a = greedy(classes, extraStudents - 1, index);
        var b = greedy(classes, extraStudents - 1, index + 1);
        classes[index][0] -= 1;
        classes[index][1] -= 1;
        var c = greedy(classes, extraStudents, index + 1);

        return Math.max(Math.max(a, b), c);
    }
}