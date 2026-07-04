class Solution {
	public int countSubstring(String s) {
		int n = s.length();
		int[] prefix = new int[n + 1];
		int min = 0, max = 0;
		
		for (int i = 1; i <= n; i++) {
			prefix[i] = prefix[i - 1] + (s.charAt(i - 1) == '1' ? 1 : -1);
			min = Math.min(min, prefix[i]);
			max = Math.max(max, prefix[i]);
		}
		
		int size = max - min + 2;
		int[] bit = new int[size + 2];
		int offset = 1 - min;
		
		long ans = 0;
		
		for (int x : prefix) {
			int idx = x + offset;
			ans += query(bit, idx - 1);
			update(bit, idx, 1);
		}
		
		return (int) ans;
	}
	
	private void update(int[] bit, int idx, int val) {
		while (idx < bit.length) {
			bit[idx] += val;
			idx += idx & -idx;
		}
	}
	
	private int query(int[] bit, int idx) {
		int sum = 0;
		while (idx > 0) {
			sum += bit[idx];
			idx -= idx & -idx;
		}
		return sum;
	}
}
