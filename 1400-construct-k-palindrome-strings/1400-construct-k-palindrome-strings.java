class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        char[] chars = s.toCharArray();

        int[] freq = new int[26];

        for (char c: chars) {
            freq[c - 'a']++;
        }

        int count = 0;

        for (int f: freq) {
            if (f % 2 == 1) count++;
        }

        return count <= k;
    }
}