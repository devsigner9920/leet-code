class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;

        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(chars[i - 1]);
                if (count != 1) {
                    sb.append(count);
                }

                count = 1;
            } else {
                count++;
            }

            if (i == chars.length - 1) {
                sb.append(chars[i]);
                if (count != 1) {
                    sb.append(count);
                }
                
            }
        }

        char[] a = sb.toString().toCharArray();
        for (int i = 0; i < a.length; i++) {
            chars[i] = a[i];
        }


        return sb.length();
    }
}