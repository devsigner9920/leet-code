class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;
        

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }

        int result = white;

        if (white == 0) {
            return 0;
        }

        int start = k;

        while (start < blocks.length()) {
            char before = blocks.charAt(start - k);
            char after = blocks.charAt(start);
            if (before == 'W' && after == 'B') {
                white--;
            }

            if (before == 'B' && after == 'W') {
                white++;
            }

            if (white == 0) {
                return 0;
            }

            result = Math.min(white, result);
            start++;
        }

        return result;
    }
}