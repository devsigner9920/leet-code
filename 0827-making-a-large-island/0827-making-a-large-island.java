class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2;  // 섬 번호 (2부터 시작)
        Map<Integer, Integer> islandSizeMap = new HashMap<>();  // 섬 번호 -> 섬 크기
        islandSizeMap.put(0, 0);  // 물인 경우 섬 크기 0

        // 1. 모든 섬에 번호를 매기고 각 섬의 크기 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizeMap.put(islandId, size);
                    islandId++;
                }
            }
        }

        // 2. 모든 0에 대해 인접한 섬의 크기를 합산하여 가장 큰 섬 크기 계산
        int maxIslandSize = islandSizeMap.getOrDefault(2, 0);  // 초기값은 섬 중 가장 큰 값

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjacentIslands = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            adjacentIslands.add(grid[ni][nj]);
                        }
                    }

                    int potentialSize = 1;  // 현재 0을 1로 바꾼 경우
                    for (int id : adjacentIslands) {
                        potentialSize += islandSizeMap.get(id);
                    }

                    maxIslandSize = Math.max(maxIslandSize, potentialSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = islandId;  // 섬 번호 매기기
        int size = 1;

        for (int k = 0; k < 4; k++) {
            size += dfs(grid, i + dx[k], j + dy[k], islandId);
        }

        return size;
    }

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
}