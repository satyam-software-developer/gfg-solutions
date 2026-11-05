class Solution {
	public int getMinimumDays(String s, int[] p) {
		int n = s.length();
		boolean[] removed = new boolean[n];
		int bad = 0;
		
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				bad++;
			}
		}
		
		if (bad == 0) {
			return 0;
		}
		
		for (int day = 0; day < n; day++) {
			int idx = p[day];
			
			if (idx > 0 && !removed[idx - 1]
			 && s.charAt(idx - 1) == s.charAt(idx)) {
				bad--;
			}
			
			if (idx < n - 1 && !removed[idx + 1]
			 && s.charAt(idx) == s.charAt(idx + 1)) {
				bad--;
			}
			
			removed[idx] = true;
			
			if (bad == 0) {
				return day + 1;
			}
		}
		
		return n;
	}
}
