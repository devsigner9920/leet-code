class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        var str1Pointer = 0;
        var str2Pointer = 0;
        var result = false;
        while (str1Pointer < str1.length()) {
            var str1Origin = str1.charAt(str1Pointer);
            var str1Next = (str1Origin == 'z') ? 'a' : (char) str1.charAt(str1Pointer) + 1;

            if (str1Origin == str2.charAt(str2Pointer) || str1Next == str2.charAt(str2Pointer)) {
                str1Pointer++;
                str2Pointer++;
            } else {
                str1Pointer++;
            }

            if (str2Pointer == str2.length()) return true;
        }

        return false;
    }
}