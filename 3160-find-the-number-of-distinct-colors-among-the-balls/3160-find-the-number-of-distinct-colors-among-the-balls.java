class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];

        // 각 공에 칠해진 색을 추적
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        
        // 각 색의 사용 횟수
        Map<Integer, Integer> colorCount = new HashMap<>();
        
        // 현재 사용된 서로 다른 색의 집합
        Set<Integer> distinctColors = new HashSet<>();

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];  // 공의 레이블
            int color = queries[i][1];  // 공에 칠할 색

            // 이전 색 제거 로직
            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                
                // 해당 색이 더 이상 사용되지 않으면 제거
                if (colorCount.get(oldColor) == 0) {
                    distinctColors.remove(oldColor);
                }
            }

            // 새로운 색 추가 로직
            ballColorMap.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            // 결과 저장
            result[i] = distinctColors.size();
        }

        return result;
    }
}