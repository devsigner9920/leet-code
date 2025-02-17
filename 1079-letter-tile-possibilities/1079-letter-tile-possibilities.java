class Solution {
    private Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1) {
            return 1;
        }
        go(tiles, new boolean[tiles.length()], "");
        return set.size() - 1;
    }

    private void go(String tiles, boolean[] visited, String str) {
        set.add(str);

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                go(tiles, visited, str + tiles.charAt(i));
                visited[i] = false;
            }
        }
    }
}