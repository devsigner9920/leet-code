import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        // words 배열 정렬 (길이 순 정렬)
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        Set<String> set = new HashSet<>();

        // 포함 관계 탐색
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    set.add(words[i]);
                    break; // 이미 추가된 단어는 중복 처리하지 않음
                }
            }
        }

        // 결과 반환 (리스트로 변환)
        return new ArrayList<>(set);
    }
}