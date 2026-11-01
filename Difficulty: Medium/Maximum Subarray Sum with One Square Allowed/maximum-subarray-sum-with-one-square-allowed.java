class Solution {
	public int maximumSubarray(int[] arr) {
		int n = arr.length;
		
		int noSquare = arr[0];
		int oneSquare = arr[0] * arr[0];
		int ans = oneSquare;
		
		for (int i = 1; i < n; i++) {
			int x = arr[i];
			
			int newOneSquare = Math.max(
			Math.max(oneSquare + x, noSquare + x * x),
			x * x
			);
			
			noSquare = Math.max(noSquare + x, x);
			oneSquare = newOneSquare;
			
			ans = Math.max(ans, oneSquare);
		}
		
		return ans;
	}
}
