class Solution {
    public int maxScore(String s) {
        int max = 0;
        int one = 0;
        int zero = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            }
        }

        max = one;

        for (int i = 0; i < s.length() - 1; i++) {
            char curChar = s.charAt(i);
            if (curChar == '0') {
                zero++;
            } else if (i != 0 && curChar == '1') {
                one--;
            }

            max = Math.max(one + zero, max);
        }

        return max;
    }
}