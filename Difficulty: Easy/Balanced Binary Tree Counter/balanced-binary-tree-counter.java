class Solution {
	public int countBT(int h) {
		long mod = 1000000007;
		
		if (h == 0)
			return 1;
		if (h == 1)
			return 1;
		
		long a = 1;
		long b = 1;
		
		for (int i = 2; i <= h; i++) {
			long c = (b * b + 2 * b * a) % mod;
			a = b;
			b = c;
		}
		
		return (int) b;
	}
}
