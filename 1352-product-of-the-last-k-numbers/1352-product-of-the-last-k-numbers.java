class ProductOfNumbers {
    private final int[] nums;
    private int position;

    public ProductOfNumbers() {
         nums = new int[40_000];
         position = 0;
    }
    
    public void add(int num) {
        nums[position++] = num;
    }
    
    public int getProduct(int k) {
        int multiply = 1;
        for (int i = position - k; i < position; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            multiply *= nums[i];
        }

        return multiply;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */