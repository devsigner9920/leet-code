
class Solution {
    private String minNumber = "999999999";  // 가능한 최댓값을 초기값으로 설정
    private Set<Integer> used = new HashSet<>(); // 사용된 숫자를 기록

    public String smallestNumber(String pattern) {
        backtrack(pattern, new StringBuilder(), 0);
        return minNumber;
    }

    private void backtrack(String pattern, StringBuilder sb, int index) {
        // 종료 조건: str 길이가 pattern.length() + 1이면 결과 갱신
        if (sb.length() == pattern.length() + 1) {
            if (minNumber.compareTo(sb.toString()) > 0) {
                minNumber = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (used.contains(i)) continue; // 중복 숫자 방지

            if (sb.length() > 0) {
                char prev = sb.charAt(sb.length() - 1);
                if (pattern.charAt(index - 1) == 'I' && prev - '0' >= i) continue;
                if (pattern.charAt(index - 1) == 'D' && prev - '0' <= i) continue;
            }

            // 선택
            sb.append(i);
            used.add(i);

            // 재귀 호출
            backtrack(pattern, sb, index + 1);

            // 백트래킹 (원래 상태로 되돌림)
            sb.deleteCharAt(sb.length() - 1);
            used.remove(i);
        }
    }
}