class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> map = new HashMap<>();

        for (String str: strs) {
            List<Character> list = new ArrayList<>();
            for (char c : str.toCharArray()) {
                list.add(c);
            }

            Collections.sort(list);
            List<String> list2 = map.getOrDefault(list, new ArrayList<String>());
            list2.add(str);
            map.put(list, list2);
        }

        List<List<String>> list = new ArrayList<>();

        for (Map.Entry<List<Character>, List<String>> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}