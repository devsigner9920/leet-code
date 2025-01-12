class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;

        Stack<Integer> opens = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                opens.push(i);
            } else if (s.charAt(i) == ')') {
                if (!opens.empty()) {
                    opens.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        while (
            !opens.empty() && !unlocked.empty() && opens.peek() < unlocked.peek()
        ) {
            opens.pop();
            unlocked.pop();
        }

        if (!opens.empty()) {
            return false;
        }

        return true;
    }
}