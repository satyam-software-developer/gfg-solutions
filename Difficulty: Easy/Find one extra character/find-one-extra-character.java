class Solution {
	public char extraChar(String s1, String s2) {
		// code here
		
		int sum1 = 0, sum2 = 0;
		
		for (int i = 0; i < s1.length(); i++) {
			sum1 += s1.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			sum2 += s2.charAt(i);
		}
		
		return (char) (sum2 - sum1);
	}
}
