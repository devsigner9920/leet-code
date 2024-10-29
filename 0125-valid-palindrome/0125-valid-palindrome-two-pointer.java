class Solution {
    public boolean isPalindrome(String s) {
        /*
         * 앞의 문자와 뒤의 문자가 대칭이 되는지 판단하는 문제
         * aman == nama
         * 두개의 포인터를 쓴다.
         * l 포인터 == 0
         * r 포인터 == s.length() - 1
         * l은 증가, r은 감소
         * 
         * 동시에 움직이며 체크하므로 시간 복잡도는 O(n)
         * 
         * 단, 대소문자 구분 없음, 그리고 알파벳과 숫자만 비교한다.
         * 만약에 두개의 포인터 중 하나라도 alphanumeric 하지 않더라면 해당 지점은 건너뛴다.
         */

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            var left = s.charAt(l);
            var right = s.charAt(r);
            // l이 알파벳 or 숫자인지 확인한다.
            if (!isAlphanumeric(left)) {
                l++;
                continue;
            }

            // r이 알파벳 or 숫자인지 확인한다.
            if (!isAlphanumeric(right)) {
                r--;
                continue;
            }

            // 둘 다 맞다면 비교하여 동일한 문자면 l++, r--
            if (Character.toLowerCase(left) == Character.toLowerCase(right)) {
                l++;
                r--;
                continue;
            }
            // 아니라면 fasle 반환
            return false;
        }

        return true;
    }

    public boolean isAlphanumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')) {
            return true;
        }

        return false;
    }
}