class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int partStart = s.indexOf(part);

            s = s.substring(0, partStart) + s.substring(partStart + part.length());
        }

        return s;
    }
}