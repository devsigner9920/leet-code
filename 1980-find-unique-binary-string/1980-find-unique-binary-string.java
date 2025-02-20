class Solution {
    Set<String> set = new HashSet<>();
    String result = "";
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        set.addAll(Arrays.stream(nums).toList());

        go(n, 0, new StringBuilder());
        
        return result;
    }

    public void go(int n, int k, StringBuilder sb) {
        if (n == k) {
            if (set.contains(sb.toString())) {
                return;
            }

            result = sb.toString();
            return;
        }
        sb.append("0");
        go(n, k + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("1");
        go(n, k + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}