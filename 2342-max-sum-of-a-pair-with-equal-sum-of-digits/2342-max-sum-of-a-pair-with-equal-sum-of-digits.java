class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Pair> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sumOfDigits = sumOfDigits(nums[i]);
            
            Pair pair = map.getOrDefault(sumOfDigits, new Pair());

            pair.add(nums[i]);

            map.put(sumOfDigits, pair);
        }
        int sum = -1;
        for (Pair pair: map.values()) {
            sum = Math.max(pair.sum(), sum);
        }

        return sum;
    }

    private int sumOfDigits(int number) {
        String numberStr = Integer.toString(number);  // 숫자를 문자열로 변환
        int sum = 0;
        
        for (char c : numberStr.toCharArray()) {  // 문자열의 각 문자(char)를 반복
            sum += Character.getNumericValue(c);  // 각 자릿수를 더함
        }
        
        return sum;
    }
}

class Pair {
    private int i;
    private int j;

    private boolean isValid() {
        return i != 0 && j != 0;
    }

    public int sum() {
        if (isValid()) {
            return i + j;
        }

        return -1;
    }

    public void add(int param) {
        if (i == 0) {
            i = param;
            return;
        }

        if (j == 0) {
            j = param;
            return;
        }

        if (i < j) {
            i = Math.max(i, param);
        } else {
            j = Math.max(j, param);
        }
    }

    @Override
    public String toString() {
        return "[" + i + ", " + j + "]";
    }
}