class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sB = new int[26];
        int[] tB = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sB[s.charAt(i) - 'a']++;
            tB[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sB[i] != tB[i]) return false;
        }

        return true;
    }
}