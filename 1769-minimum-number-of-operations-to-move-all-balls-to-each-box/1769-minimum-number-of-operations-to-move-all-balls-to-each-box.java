class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];

        // bruteforce
        // for (int currentBox = 0; currentBox < boxes.length(); currentBox++) {
        //     if (boxes.charAt(currentBox) == '1') {
        //         for (int newPosition = 0; newPosition < boxes.length(); newPosition++) {
        //             answer[newPosition] += Math.abs(newPosition - currentBox);
        //         }
        //     }
        // }

        // sum of left and right moves
        int ballsToLeft = 0;
        int movesToLeft = 0;

        int ballsToRight = 0;
        int movesToRight = 0;

        for (int i = 0; i < boxes.length(); i++) {
            answer[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;

            int j = boxes.length() - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballsToRight;
        }

        return answer;
    }
}