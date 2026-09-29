import java.util.*;

class Solution {
    public int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
        int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        int sr = knightPos[0] - 1;
        int sc = knightPos[1] - 1;
        int tr = targetPos[0] - 1;
        int tc = targetPos[1] - 1;

        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int steps = cur[2];

            if (r == tr && c == tc) {
                return steps;
            }

            for (int[] move : moves) {
                int nr = r + move[0];
                int nc = c + move[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, steps + 1});
                }
            }
        }

        return -1;
    }
}