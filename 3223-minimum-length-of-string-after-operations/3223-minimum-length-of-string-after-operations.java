class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int del = 0;

        for (int fr: freq.values()) {
            if (fr % 2 == 1) {
                del += fr - 1;
            } else {
                del += fr - 2;
            }
        }

        return s.length() - del;
    }
}