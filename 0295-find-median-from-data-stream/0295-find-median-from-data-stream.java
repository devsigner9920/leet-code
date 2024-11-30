class MedianFinder {
    private final List<Integer> numbers;

    public MedianFinder() {
        this.numbers = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        int pos = binarySearch(num);

        if (pos < 0) {
            pos = -(pos + 1);
        }

        this.numbers.add(pos, num);
    }

    private int binarySearch(int target) {
        int left = 0;
        int right = this.numbers.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (this.numbers.get(mid) == target) {
                return mid; // 값을 찾으면 인덱스 반환
            } else if (this.numbers.get(mid) < target) {
                left = mid + 1; // 오른쪽 부분 탐색
            } else {
                right = mid - 1; // 왼쪽 부분 탐색
            }
        }

        // 값이 없으면 삽입 위치 반환
        return -(left + 1);
    }
    
    public double findMedian() {
        var isEven = (this.numbers.size() % 2) == 0 ? true : false;

        if (isEven) {
            var right = this.numbers.size() / 2;
            var left = right - 1;
            return (double) (numbers.get(right) + numbers.get(left)) / 2;
        }

        return this.numbers.get(this.numbers.size() / 2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */