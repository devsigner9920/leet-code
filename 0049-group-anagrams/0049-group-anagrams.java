class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            var charArr = strs[i].toCharArray();
            Arrays.sort(charArr);

            var sortedString = new String(charArr);

            if (map.containsKey(new String(charArr))) {
                int finalI = i;
                map.computeIfPresent(sortedString, (key, strings) -> {strings.add(strs[finalI]); return strings;});
            } else {
                var arr = new ArrayList<String>();
                arr.add(strs[i]);
                map.put(sortedString, arr);
            }
        }

        return map.values().stream().toList();
    }
}