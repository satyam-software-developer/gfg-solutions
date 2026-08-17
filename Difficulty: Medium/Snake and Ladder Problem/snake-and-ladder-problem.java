class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int total = n * n;

        int[] move = new int[total + 1];

        for (int i = 0; i < lad.length; i += 2) {
            move[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            move[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[total + 1];
        int[] queue = new int[total + 1];
        int[] distance = new int[total + 1];

        int front = 0;
        int rear = 0;

        queue[rear++] = 1;
        visited[1] = true;

        while (front < rear) {
            int current = queue[front++];

            if (current == total) {
                return distance[current];
            }

            for (int dice = 1; dice <= 6 && current + dice <= total; dice++) {
                int next = current + dice;

                if (move[next] != 0) {
                    next = move[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue[rear++] = next;
                }
            }
        }

        return -1;
    }
}