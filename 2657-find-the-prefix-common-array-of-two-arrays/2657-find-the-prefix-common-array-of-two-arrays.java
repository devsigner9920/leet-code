class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefix = new int[n];

        Set<Integer> elementsInA = new HashSet<Integer>();
        Set<Integer> elementsInB = new HashSet<Integer>();

        for (int i = 0; i < n; ++i) {
            elementsInA.add(A[i]);
            elementsInB.add(B[i]);

            int comCount = 0;

            for (int ele: elementsInA) {
                if (elementsInB.contains(ele)) {
                    ++comCount;
                }
            }

            prefix[i] = comCount;
        }

        return prefix;
    }
}