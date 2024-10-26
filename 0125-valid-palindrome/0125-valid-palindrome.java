class Solution {
    public boolean isPalindrome(String s) {
        List<Character> charList = new ArrayList<>();
        var chars = s.toCharArray();
        for (char c: chars) {
            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90) || Character.isDigit(c)) {
                charList.add(Character.toLowerCase(c));
            }
        }


        var middlePosition = (int) Math.ceil(charList.size() / 2f);

        for (int i = 0; i < middlePosition; i++) {
            if (charList.get(i) != charList.get(charList.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}