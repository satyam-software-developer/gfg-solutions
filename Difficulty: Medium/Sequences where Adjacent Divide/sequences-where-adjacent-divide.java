class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n][m + 1];

        for (int j = 1; j <= m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int curr = 1; curr <= m; curr++) {
                int ways = 0;
                for (int prev = 1; prev <= m; prev++) {
                    if (curr % prev == 0 || prev % curr == 0) {
                        ways += dp[i - 1][prev];
                    }
                }
                dp[i][curr] = ways;
            }
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans += dp[n - 1][j];
        }

        return ans;
    }
}