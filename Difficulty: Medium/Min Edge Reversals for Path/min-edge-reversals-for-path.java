class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        ArrayList<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(new int[]{v, 0});
            graph[v].add(new int[]{u, 1});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(src);

        while (!deque.isEmpty()) {
            int u = deque.pollFirst();

            for (int[] next : graph[u]) {
                int v = next[0];
                int cost = next[1];

                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;

                    if (cost == 0) {
                        deque.addFirst(v);
                    } else {
                        deque.addLast(v);
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}