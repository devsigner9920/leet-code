class Solution {
    public boolean canChange(String start, String target) {
        var startQ = new LinkedList<Pair<Character, Integer>>();
        var targetQ = new LinkedList<Pair<Character, Integer>>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startQ.add(new Pair<>(start.charAt(i), i));
            }

            if (target.charAt(i) != '_') {
                targetQ.add(new Pair<>(target.charAt(i), i));
            }
        }

        if (startQ.size() != targetQ.size()) return false;

        while (!startQ.isEmpty()) {
            var startP = startQ.poll();
            var targetP = targetQ.poll();

            var startChar = startP.getKey();
            var startIndex = startP.getValue();
            var targetChar = targetP.getKey();
            var targetIndex = targetP.getValue();

            if (startChar != targetChar) return false;

            if (startChar == 'L' && startIndex < targetIndex) return false;
            if (startChar == 'R' && startIndex > targetIndex) return false;
        }

        return true;
    }
}