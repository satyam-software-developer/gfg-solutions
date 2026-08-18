class Solution {
    public String compress(String s) {
        int n = s.length();

        int[] z = new int[n];
        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];

            if (i > 0 && 2 * i <= n && z[i] >= i) {
                dp[i] = Math.min(dp[i], 1 + dp[2 * i]);
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (i > 0 && 2 * i <= n && z[i] >= i && dp[i] == 1 + dp[2 * i]) {
                result.append('*');
                i *= 2;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}