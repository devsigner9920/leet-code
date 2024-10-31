class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        var result = "";
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;

        var tHashMap = new HashMap<Character, Integer>();
        var sHashMap = new HashMap<Character, Integer>();

        // tHashMap에 t의 문자 카운트 추가
        for (int i = 0; i < t.length(); i++) {
            tHashMap.put(t.charAt(i), tHashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int requiredMatch = tHashMap.size(); // 필요한 문자 종류의 개수
        int currentMatch = 0; // 현재 일치하는 문자 종류의 개수

        while (r < s.length()) {
            // 오른쪽 포인터의 문자 추가
            char rChar = s.charAt(r);
            sHashMap.put(rChar, sHashMap.getOrDefault(rChar, 0) + 1);

            // 현재 문자 카운트가 t의 문자 요구 카운트를 충족할 경우 currentMatch 증가
            if (tHashMap.containsKey(rChar) && sHashMap.get(rChar).equals(tHashMap.get(rChar))) {
                currentMatch++;
            }

            // 모든 필요한 문자가 충족되었을 때 윈도우 축소 시도
            while (currentMatch == requiredMatch) {
                // 최소 길이 갱신
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    result = s.substring(l, r + 1);
                }

                // 왼쪽 포인터 이동
                char lChar = s.charAt(l);
                sHashMap.put(lChar, sHashMap.get(lChar) - 1);
                if (tHashMap.containsKey(lChar) && sHashMap.get(lChar) < tHashMap.get(lChar)) {
                    currentMatch--; // 필요한 문자 조건을 충족하지 못할 경우 감소
                }
                l++;
            }
            r++;
        }

        return result;
    }

}