class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {
        int[] freq = new int[31];
        for (int x : arr) freq[x]++;

        int[] primes = {2,3,5,7,11,13,17,19,23,29};
        int[] mask = new int[31];

        for (int i = 2; i <= 30; i++) {
            int x = i;
            int m = 0;
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                int p = primes[j];
                int c = 0;
                while (x % p == 0) {
                    x /= p;
                    c++;
                }
                if (c > 1) {
                    ok = false;
                    break;
                }
                if (c == 1) m |= 1 << j;
            }
            mask[i] = ok ? m : -1;
        }

        long[] dp = new long[1024];
        dp[0] = 1;

        for (int v = 2; v <= 30; v++) {
            if (freq[v] == 0 || mask[v] == -1) continue;
            long[] ndp = dp.clone();
            int m = mask[v];
            for (int s = 0; s < 1024; s++) {
                if ((s & m) == 0) {
                    ndp[s | m] = (ndp[s | m] + dp[s] * freq[v]) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int s = 1; s < 1024; s++) {
            ans = (ans + dp[s]) % MOD;
        }

        long mul = 1;
        for (int i = 0; i < freq[1]; i++) {
            mul = (mul * 2) % MOD;
        }

        ans = (ans * mul) % MOD;
        return (int) ans;
    }
}