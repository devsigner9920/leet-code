class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
              || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
              || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}