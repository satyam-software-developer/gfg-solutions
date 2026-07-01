class Solution {
	static String compareNum(int A, int B) {
		// code here
		
		if (A > B) {
			return A + " is greater than " + B;
		}
		else if (A < B) {
			return A + " is less than " + B;
		}
		else {
			return A + " is equals to " + B;
		}
		
	}
}
