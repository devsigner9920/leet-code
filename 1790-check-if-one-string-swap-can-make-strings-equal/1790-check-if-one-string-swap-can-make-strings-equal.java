class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1Arr = new char[2];
        char[] s2Arr = new char[2];
        int difCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            char s1C = s1.charAt(i);
            char s2C = s2.charAt(i);
            if (s1C != s2C) {
                if (difCount == 2) {
                    return false;
                }
                s1Arr[difCount] = s1C;
                s2Arr[difCount] = s2C;
                difCount++;
            }
        }

        if (difCount < 2) {
            return false;
        }

        return s1Arr[0] == s2Arr[1] && s1Arr[1] == s2Arr[0];
    }
}