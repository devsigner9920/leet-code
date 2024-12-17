class Solution {
    public String addSpaces(String s, int[] spaces) {
        boolean[] check = new boolean[s.length()];

        for (int space: spaces) {
            check[space] = true;
        }

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (check[i]) {
                sb.append(" ");
            }

            sb.append(arr[i]);
        }

        return sb.toString();
    }
}