import java.util.Arrays;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        // 0, 1은 소수가 아님
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체를 사용하여 소수 판별
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int first = -1, second = -1;
        int minDiff = Integer.MAX_VALUE;

        int prevPrime = -1;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prevPrime != -1) {  // 이전 소수가 존재하면 차이를 계산
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        minDiff = diff;
                        first = prevPrime;
                        second = i;
                    }
                }
                prevPrime = i;  // 현재 소수를 이전 소수로 갱신
            }
        }

        // 유효한 소수 쌍이 없을 경우
        if (first == -1 || second == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{first, second};
    }
}