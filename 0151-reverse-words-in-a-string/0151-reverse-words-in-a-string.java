class Solution {
    public String reverseWords(String s) {
        String[] newS = s.trim().split(" ");

        StringBuffer sb = new StringBuffer();

        for (int i = newS.length - 1; i >= 0; i--) {
            String str = newS[i].trim();
            if (str.isEmpty()) continue;
            sb.append(str);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}