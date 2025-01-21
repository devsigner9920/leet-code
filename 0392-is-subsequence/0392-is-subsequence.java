class Solution {
    public boolean isSubsequence(String s, String t) {
        // s의 포인터
        int l = 0;
        // t의 포인터
        int r = 0;

        while (l < s.length()) {
            char target = s.charAt(l);

            while (r < t.length()) {
                char current = t.charAt(r++);
                if (target == current) {
                    l++;
                    break;
                }
            }

            if (r == t.length()) {
                break;
            }
        }

        return l == s.length();
    }
}