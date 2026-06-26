class Solution {
    public static int countWays(String s1, String s2) {
        int mod = 1000000007;
        int n = s1.length();
        int m = s2.length();

        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[j + 1] = (dp[j + 1] + dp[j]) % mod;
                }
            }
        }

        return (int) dp[m];
    }
}