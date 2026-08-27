class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = mat[i][j] == 1 ? height[j] + 1 : 0;
            }

            int[] sorted = height.clone();
            java.util.Arrays.sort(sorted);

            for (int j = 0; j < m; j++) {
                maxArea = Math.max(maxArea, sorted[j] * (m - j));
            }
        }

        return maxArea;
    }
}