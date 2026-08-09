class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = -1, max2 = -1, idx = -1;

            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] > max1) {
                    max2 = max1;
                    max1 = dp[i - 1][j];
                    idx = j;
                } else if (dp[i - 1][j] > max2) {
                    max2 = dp[i - 1][j];
                }
            }

            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] + (j == idx ? max2 : max1);
            }
        }

        int ans = 0;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[n - 1][j]);
        }

        return ans;
    }
}