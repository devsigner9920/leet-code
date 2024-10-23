class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var sCharArr = s.toCharArray();
        var tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);

        for (int i = 0; i < sCharArr.length; i++) {
            if (sCharArr[i] != tCharArr[i]) {
                return false;
            }
        }

        return true;
    }
}