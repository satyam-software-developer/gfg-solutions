class Solution {
    public int prefixStrings(int n) {
        long mod = 1000000007L;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
        }

        long result = dp[n];

        long[] fact = new long[2 * n + 1];
        long[] invFact = new long[2 * n + 1];

        fact[0] = 1;
        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }

        invFact[2 * n] = power(fact[2 * n], mod - 2, mod);
        for (int i = 2 * n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % mod;
        }

        long combinations = fact[2 * n] * invFact[n] % mod * invFact[n] % mod;
        long invalid = fact[2 * n] * invFact[n - 1] % mod * invFact[n + 1] % mod;

        return (int) ((combinations - invalid + mod) % mod);
    }

    private long power(long a, long b, long mod) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }

        return result;
    }
}