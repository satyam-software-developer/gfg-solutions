class Solution {
	static final int MOD = 1000000007;
	
	int gcd(int a, int b) {
		while (b != 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}
	
	long lcm(long a, long b) {
		return (a / gcd((int)a, (int)b)) * b;
	}
	
	int minOperations(int[] b) {
		int n = b.length;
		boolean[] vis = new boolean[n];
		long ans = 1;
		
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				int len = 0;
				int cur = i;
				
				while (!vis[cur]) {
					vis[cur] = true;
					cur = b[cur] - 1;
					len++;
				}
				
				ans = lcm(ans, len);
			}
		}
		
		return (int)(ans % MOD);
	}
}
