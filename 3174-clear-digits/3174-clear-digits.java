class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }
}