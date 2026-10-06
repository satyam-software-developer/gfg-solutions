class Solution {
    public int longIncPath(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        int ans = 1;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] cells = new int[n * m][3];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cells[k][0] = matrix[i][j];
                cells[k][1] = i;
                cells[k][2] = j;
                k++;
            }
        }

        java.util.Arrays.sort(cells, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] cell : cells) {
            int val = cell[0];
            int r = cell[1];
            int c = cell[2];
            int best = 1;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    matrix[nr][nc] < val) {
                    best = Math.max(best, dp[nr][nc] + 1);
                }
            }

            dp[r][c] = best;
            ans = Math.max(ans, best);
        }

        return ans;
    }
}