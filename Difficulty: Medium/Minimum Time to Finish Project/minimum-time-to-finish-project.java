class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        int[] indegree = new int[n];
        int[] earliest = new int[n];
        int[] queue = new int[n];
        int head = 0, tail = 0;

        int[][] graph = new int[n][];
        int[] count = new int[n];

        for (int[] edge : dependencies) {
            count[edge[0]]++;
        }

        for (int i = 0; i < n; i++) {
            graph[i] = new int[count[i]];
        }

        int[] pos = new int[n];

        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];
            graph[u][pos[u]++] = v;
            indegree[v]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[tail++] = i;
                earliest[i] = duration[i];
            }
        }

        int processed = 0;
        int answer = 0;

        while (head < tail) {
            int u = queue[head++];
            processed++;

            answer = Math.max(answer, earliest[u]);

            for (int v : graph[u]) {
                earliest[v] = Math.max(earliest[v], earliest[u] + duration[v]);

                if (--indegree[v] == 0) {
                    queue[tail++] = v;
                }
            }
        }

        return processed == n ? answer : -1;
    }
}