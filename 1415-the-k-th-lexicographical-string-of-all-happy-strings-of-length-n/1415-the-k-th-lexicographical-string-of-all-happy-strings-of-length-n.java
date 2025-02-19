class Solution {
    private String[] result;
    private int idx = 0;
    public String getHappyString(int n, int k) {
        result = new String[k];
        go(n, k, new StringBuilder());

        return (result[k - 1] == null) ? "" : result[k - 1];
    }

    private void go(int n, int k, StringBuilder str) {
        if (idx == k) {
            return;
        }

        if (str.length() == n) {
            result[idx++] = str.toString();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == 'a' + i) continue;

            str.append((char) ('a' + i));

            go(n, k, str);

            str.deleteCharAt(str.length() - 1);
        }
    }
}