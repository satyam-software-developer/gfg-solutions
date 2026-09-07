class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        int maxSelected = solve(arr, 0, -1, -1, dp);
        return n - maxSelected;
    }

    private int solve(int[] arr, int pos, int inc, int dec, int[][][] dp) {
        if (pos == arr.length) {
            return 0;
        }

        int i = inc + 1;
        int d = dec + 1;

        if (dp[pos][i][d] != -1) {
            return dp[pos][i][d];
        }

        int ans = solve(arr, pos + 1, inc, dec, dp);

        if (inc == -1 || arr[pos] > arr[inc]) {
            ans = Math.max(ans, 1 + solve(arr, pos + 1, pos, dec, dp));
        }

        if (dec == -1 || arr[pos] < arr[dec]) {
            ans = Math.max(ans, 1 + solve(arr, pos + 1, inc, pos, dp));
        }

        return dp[pos][i][d] = ans;
    }
}