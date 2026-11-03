import java.util.*;

class Solution {
	public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
		Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
		
		int m = queries.length;
		int[][] q = new int[m][2];
		
		for (int i = 0; i < m; i++) {
			q[i][0] = queries[i];
			q[i][1] = i;
		}
		
		Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
		
		int[] parent = new int[n + 1];
		int[] size = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(m, 0));
		
		int j = 0;
		long count = 0;
		
		for (int i = 0; i < m; i++) {
			int limit = q[i][0];
			
			while (j < edges.length && edges[j][2] <= limit) {
				int u = find(parent, edges[j][0]);
				int v = find(parent, edges[j][1]);
				
				if (u != v) {
					count += (long) size[u] * size[v];
					
					if (size[u] < size[v]) {
						int temp = u;
						u = v;
						v = temp;
					}
					
					parent[v] = u;
					size[u] += size[v];
				}
				
				j++;
			}
			
			ans.set(q[i][1], (int) count);
		}
		
		return ans;
	}
	
	private int find(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = find(parent, parent[x]);
		}
		return parent[x];
	}
}
