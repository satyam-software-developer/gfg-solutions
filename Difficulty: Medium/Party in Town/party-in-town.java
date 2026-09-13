class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        int[] first = bfs(adj, 1, n);
        int[] second = bfs(adj, first[0], n);

        return (second[1] + 1) / 2;
    }

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        int[] queue = new int[n];
        int front = 0;
        int rear = 0;

        queue[rear++] = start;
        dist[start] = 0;

        int farthest = start;

        while (front < rear) {
            int u = queue[front++];

            for (int v : adj.get(u - 1)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue[rear++] = v;

                    if (dist[v] > dist[farthest]) {
                        farthest = v;
                    }
                }
            }
        }

        return new int[]{farthest, dist[farthest]};
    }
}