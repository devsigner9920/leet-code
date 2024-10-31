class Solution {
    public int characterReplacement(String s, int k) {
        // 대문자 A - Z 까지 26자이므로 각각 문자를 카운팅하는 배열
        var arr = new int[26];
        var result = 0;
        
        // 현재 윈도우 안에서 제일 큰 수!!!!!
        var max = 0;

        // 슬라이딩 윈도우가 l = 0; r = 0 부터 시작함 겹친 상태서 시작
        var l = 0;

        for (int r = 0; r < s.length(); r++) {
            // 각각의 char가 s 안에 몇개나 들어있는지 카운팅 한다.
            // char A 부터 시작하니까 A - A == 0 이므로 0번째부터 A-Z 카운트 기록
            arr[s.charAt(r) - 'A']++;

            // 현재 위치의 알파벳의 갯수와 max값과 비교한다.
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            // (현재 윈도우 크기 - 현재 윈도우안에서 제일 큰 수의 갯수) 가 k 보다 크다면
            // 현재 윈도우의 모든 불일치 수들을 k개 만큼 바꿔줄 수 없으니 l을 증가시켜 윈도우를 축소시킨다.
            // 그와 동시에 l이 커지니까 기존 l 위치에 있던 알파벳 카운트를 -1 시킨다.
            if (r - l + 1 - max > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}