class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char open = stack.pop();
                
                if (open == '(') {
                    if (c != ')') return false;
                }

                if (open == '{') {
                    if (c != '}') return false;
                }

                if (open == '[') {
                    if (c != ']') return false;
                }
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }
}