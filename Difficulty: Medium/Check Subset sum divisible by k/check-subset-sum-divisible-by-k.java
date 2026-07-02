class Solution {
	public boolean divisibleByK(int[] arr, int k) {
		boolean[] dp = new boolean[k];
		
		for (int num : arr) {
			boolean[] next = dp.clone();
			next[num % k] = true;
			
			for (int i = 0; i < k; i++) {
				if (dp[i]) {
					next[(i + num) % k] = true;
				}
			}
			
			dp = next;
			
			if (dp[0]) {
				return true;
			}
		}
		
		return false;
	}
}
