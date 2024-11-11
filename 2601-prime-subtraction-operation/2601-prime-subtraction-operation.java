class Solution {
    public boolean primeSubOperation(int[] nums) {
        var primes = makePrimes();
        int prev = 0; // 이전 요소를 추적하여 엄격히 증가하도록 보장

        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            
            // 이전 요소보다 크도록 만듦
            for (int prime = original - 1; prime > 1; prime--) {
                if (!primes[prime] && original - prime > prev) {
                    nums[i] = original - prime;
                    break;
                }
            }
            
            // 조건을 만족하지 않으면 실패
            if (nums[i] <= prev) return false;
            prev = nums[i]; // 현재 요소를 이전 요소로 업데이트
        }
        
        return true;
    }

    private boolean[] makePrimes() {
        var primes = new boolean[1001];
        primes[0] = primes[1] = true;
        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (!primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = true;
                }
            }
        }
        return primes;
    }
}
