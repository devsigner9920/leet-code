class Solution {
    public int maximumLength(String s) {
        var count = new HashMap<String, Integer>();

        for (int start = 0; start < s.length(); start++) {
            var current = new StringBuffer();

            for (int end = start; end < s.length(); end++) {
                if (current.length() == 0 || current.charAt(current.length() - 1) == s.charAt(end)) {
                    current.append(s.charAt(end));

                    count.put(current.toString(), count.getOrDefault(current.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }

        var answer = -1;
        for (String str: count.keySet()) {
            if (count.get(str) >= 3 && str.length() > answer) {
                answer = str.length();
            }
        }

        return answer;
    }
}