class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int mod = 1000000007;

        long[][] paths = new long[n][n];
        int[][] max = new int[n][n];

        paths[0][0] = 1;
        max[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                long count = 0;
                int best = -1;

                if (i > 0 && grid[i - 1][j] != 1) {
                    count = (count + paths[i - 1][j]) % mod;
                    if (paths[i - 1][j] > 0) {
                        best = Math.max(best, max[i - 1][j]);
                    }
                }

                if (j > 0 && grid[i][j - 1] != 2) {
                    count = (count + paths[i][j - 1]) % mod;
                    if (paths[i][j - 1] > 0) {
                        best = Math.max(best, max[i][j - 1]);
                    }
                }

                paths[i][j] = count;

                if (best != -1) {
                    max[i][j] = best + grid[i][j];
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) paths[n - 1][n - 1]);
        ans.add(max[n - 1][n - 1]);

        return ans;
    }
}