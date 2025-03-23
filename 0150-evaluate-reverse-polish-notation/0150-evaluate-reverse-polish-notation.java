class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        int result = 0;

        for (String token: tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                if (token.equals("+")) {
                    stack.add((b + a) + "");
                }

                if (token.equals("-")) {
                    stack.add((b - a) + "");
                }

                if (token.equals("*")) {
                    stack.add((b * a) + "");
                }

                if (token.equals("/")) {
                    stack.add((b / a) + "");
                }
            } else {
                stack.add(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}