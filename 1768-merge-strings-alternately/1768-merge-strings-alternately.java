class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = 0;

        while (left != word1.length() || right != word2.length()) {
            if(left < word1.length()) {
                sb.append(word1.charAt(left));
                left++;
            }

            if(right < word2.length()) {
                sb.append(word2.charAt(right));
                right++;
            }
        }

        return sb.toString();
    }
}