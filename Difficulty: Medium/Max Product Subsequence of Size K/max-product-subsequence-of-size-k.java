class Solution {
    public int maxProduct(int[] arr, int k) {
        long[][] dp = new long[k + 1][2];
        long NEG = Long.MIN_VALUE / 4;
        long POS = Long.MAX_VALUE / 4;

        for (int i = 0; i <= k; i++) {
            dp[i][0] = NEG;
            dp[i][1] = POS;
        }

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int x : arr) {
            for (int j = k; j >= 1; j--) {
                long max = dp[j - 1][0];
                long min = dp[j - 1][1];

                if (max != NEG && min != POS) {
                    long a = max * x;
                    long b = min * x;

                    dp[j][0] = Math.max(dp[j][0], Math.max(a, b));
                    dp[j][1] = Math.min(dp[j][1], Math.min(a, b));
                }
            }
        }

        return (int) dp[k][0];
    }
}