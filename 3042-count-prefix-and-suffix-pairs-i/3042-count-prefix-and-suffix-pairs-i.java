class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;

        // Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }

                String prefix = words[j].substring(0, words[i].length());
                String suffix = words[j].substring(words[j].length() - words[i].length(), words[j].length());
                if (prefix.equals(words[i]) && suffix.equals(words[i])) {
                    result++;
                }
            }
        }

        return result;
    }
}