class Solution {
    public int lengthOfLongestSubstring(String s) {
        var left = 0;
        var maxLength = 0;
        var set = new HashSet<Character>();

        for (int right = 0; right < s.length(); right++) {
            var currentChar = s.charAt(right);
            // set 에 right 번째 문자가 계속 존재한다면 loop를 돌아 left 를 ++ 시킨다.
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // set에 right 번째를 저장시킨다.
            set.add(currentChar);
            // maxLength 와 현재 포지션을 비교해서 max값 세팅한다.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}