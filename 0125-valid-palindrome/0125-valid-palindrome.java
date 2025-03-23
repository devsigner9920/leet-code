class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if (!Character.isAlphabetic(lc) && !Character.isDigit(lc)) {
                left++;
                continue;
            }

            if (!Character.isAlphabetic(rc) && !Character.isDigit(rc)) {
                right--;
                continue;
            }

            if (Character.isDigit(lc)) {
                if (lc != rc) {
                    return false;
                }
            }

            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }
            
            left++;
            right--;
        }

        return true;
    }
}