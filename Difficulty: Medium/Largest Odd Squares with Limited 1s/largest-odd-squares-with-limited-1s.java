class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];

            int maxRadius = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            if (getSum(prefix, r, c, r, c) > k) {
                result.add(-1);
                continue;
            }

            int low = 0;
            int high = maxRadius;
            int best = 0;

            while (low <= high) {
                int radius = low + (high - low) / 2;

                int r1 = r - radius;
                int c1 = c - radius;
                int r2 = r + radius;
                int c2 = c + radius;

                int ones = getSum(prefix, r1, c1, r2, c2);

                if (ones <= k) {
                    best = radius;
                    low = radius + 1;
                } else {
                    high = radius - 1;
                }
            }

            result.add(2 * best + 1);
        }

        return result;
    }

    private int getSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        return prefix[r2 + 1][c2 + 1]
                - prefix[r1][c2 + 1]
                - prefix[r2 + 1][c1]
                + prefix[r1][c1];
    }
}