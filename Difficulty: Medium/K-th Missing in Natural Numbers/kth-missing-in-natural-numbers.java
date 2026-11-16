class Solution {
	public int findKthSmall(int[] arr, int k) {
		int low = 1;
		int high = k + arr.length;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			
			for (int num : arr) {
				if (num <= mid) {
					count++;
				}
			}
			
			int remaining = mid - count;
			
			if (remaining >= k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
}
