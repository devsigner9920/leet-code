class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];  // 'a', 'b', 'c' 개수를 저장하는 배열
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) { // right는 윈도우의 끝을 확장
            count[s.charAt(right) - 'a']++;

            // "abc"가 모두 포함될 때까지 left를 이동
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - right;  // 가능한 모든 부분 문자열 개수 추가
                count[s.charAt(left) - 'a']--; // left를 이동하면서 문자 개수 감소
                left++;  // left를 한 칸 이동
            }
        }

        return result;
    }
}