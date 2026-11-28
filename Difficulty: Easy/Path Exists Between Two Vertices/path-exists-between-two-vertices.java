class Solution {
  public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new LinkedList<>();

    queue.offer(u);
    visited[u] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();

      if (node == v) {
        return true;
      }

      for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }

    return false;
  }
}