class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;

        var stack = new Stack<Character>();

        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
                continue;
            }

            if (c == '{') {
                stack.push('}');
                continue;
            }

            if (c == '[') {
                stack.push(']');
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
             
            if (stack.pop() != c) {
                return false;
             }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}