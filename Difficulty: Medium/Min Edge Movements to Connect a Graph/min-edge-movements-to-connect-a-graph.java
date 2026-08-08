class Solution {
    int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int components = n;

        for (int[] edge : edges) {
            int u = find(parent, edge[0]);
            int v = find(parent, edge[1]);

            if (u != v) {
                if (size[u] < size[v]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }

                parent[v] = u;
                size[u] += size[v];
                components--;
            }
        }

        return components - 1;
    }

    int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}