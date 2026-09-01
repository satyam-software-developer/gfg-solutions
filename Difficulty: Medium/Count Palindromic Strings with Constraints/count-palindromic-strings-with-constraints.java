class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007L;
        long ans = 0;

        for (int len = 1; len <= n; len++) {
            int half = len / 2;
            long ways = 1;

            for (int j = 0; j < half; j++) {
                ways = ways * (k - j) % MOD;
            }

            if (len % 2 == 0) {
                ans = (ans + ways) % MOD;
            } else {
                long oddWays = ways * (k - half) % MOD;
                ans = (ans + oddWays) % MOD;
            }
        }

        return (int) ans;
    }
}