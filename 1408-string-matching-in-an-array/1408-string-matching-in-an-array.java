import java.util.*;

class Solution {
    // KMP 알고리즘: 텍스트에 패턴이 포함되는지 확인
    private boolean kmpContains(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0; // i: text 포인터, j: pattern 포인터

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return true; // 패턴 매칭 성공
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // LPS (Longest Prefix Suffix) 배열 계산
    private int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // prefix 길이
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();

        // 각 단어를 다른 단어에 대해 KMP 탐색
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && kmpContains(words[j], words[i])) {
                    result.add(words[i]);
                    break; // 이미 추가된 단어는 다시 확인하지 않음
                }
            }
        }

        // 결과를 리스트로 반환
        return new ArrayList<>(result);
    }
}