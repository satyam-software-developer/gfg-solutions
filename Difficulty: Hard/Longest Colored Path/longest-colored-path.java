class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        int[][] g = new int[n][];
        int[] deg = new int[n];

        for (int[] e : edges) {
            deg[e[0] - 1]++;
            deg[e[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            g[i] = new int[deg[i]];
        }

        int[] idx = new int[n];
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            g[u][idx[u]++] = v;
            g[v][idx[v]++] = u;
        }

        int[] parent = new int[n];
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0, size = 0;

        stack[top++] = 0;
        parent[0] = -2;

        while (top > 0) {
            int u = stack[--top];
            order[size++] = u;

            for (int v : g[u]) {
                if (v != parent[u]) {
                    parent[v] = u;
                    stack[top++] = v;
                }
            }
        }

        int[] down = new int[n];
        int answer = 1;

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int best1 = 0, best2 = 0;

            for (int v : g[u]) {
                if (parent[v] == u && s.charAt(v) == s.charAt(u)) {
                    int val = down[v];
                    if (val > best1) {
                        best2 = best1;
                        best1 = val;
                    } else if (val > best2) {
                        best2 = val;
                    }
                }
            }

            down[u] = best1 + 1;
            answer = Math.max(answer, best1 + best2 + 1);
        }

        int[] up = new int[n];

        for (int u : order) {
            int best1 = 0, best2 = 0;
            int bestChild = -1;

            for (int v : g[u]) {
                if (parent[v] == u && s.charAt(v) == s.charAt(u)) {
                    int val = down[v];
                    if (val > best1) {
                        best2 = best1;
                        best1 = val;
                        bestChild = v;
                    } else if (val > best2) {
                        best2 = val;
                    }
                }
            }

            for (int v : g[u]) {
                if (parent[v] == u && s.charAt(v) == s.charAt(u)) {
                    int best = (v == bestChild ? best2 : best1);
                    up[v] = Math.max(up[u] + 1, best + 2);
                }
            }
        }

        int[] ecc = new int[n];

        for (int u = 0; u < n; u++) {
            ecc[u] = Math.max(down[u], up[u]);
        }

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            if (s.charAt(u) != s.charAt(v)) {
                answer = Math.max(answer, ecc[u] + ecc[v]);
            }
        }

        return answer;
    }
}