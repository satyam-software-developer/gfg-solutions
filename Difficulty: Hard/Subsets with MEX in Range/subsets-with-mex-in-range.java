class Solution {
    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;
        long MOD = 1000000007L;

        int[] freq = new int[n + 1];

        for (int x : arr) {
            if (x <= n) {
                freq[x]++;
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long ans = 0;
        long product = 1;
        int prefix = 0;

        for (int mex = 0; mex <= n; mex++) {
            prefix += freq[mex];

            long ways = (product * pow2[n - prefix]) % MOD;

            if (mex >= l && mex <= r) {
                ans = (ans + ways) % MOD;
            }

            product = (product * (pow2[freq[mex]] - 1 + MOD)) % MOD;
        }

        return (int) ans;
    }
}