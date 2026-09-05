class Solution {
    public int longestSubseq(int[] arr) {
        int[] dp = new int[1000002];
        int ans = 1;

        for (int num : arr) {
            dp[num] = Math.max(dp[num - 1], dp[num + 1]) + 1;
            ans = Math.max(ans, dp[num]);
        }

        return ans;
    }
}