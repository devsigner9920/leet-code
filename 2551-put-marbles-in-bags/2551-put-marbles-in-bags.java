class Solution {
    public long putMarbles(int[] weights, int k) {
    List<Integer> pairs = new ArrayList<>();
    for (int i = 0; i < weights.length - 1; i++) {
        pairs.add(weights[i] + weights[i + 1]);
    }

    Collections.sort(pairs); // 오름차순 정렬

    long min = 0, max = 0;
    for (int i = 0; i < k - 1; i++) {
        min += pairs.get(i);
        max += pairs.get(pairs.size() - 1 - i);
    }

    return max - min;
}
}