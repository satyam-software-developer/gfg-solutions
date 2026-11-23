import java.util.*;

class Solution {
	public char posInfinite(String s, int pos) {
		long p = pos;
		ArrayList<Long> len = new ArrayList<>();
		
		len.add((long) s.length());
		
		for (long i = 1; len.get(len.size() - 1) < p; i++) {
			long oldLen = len.get(len.size() - 1);
			len.add(2 * oldLen + i);
		}
		
		for (int i = len.size() - 1; i > 0; i--) {
			long oldLen = len.get(i - 1);
			long currentLen = len.get(i);
			
			if (p > oldLen + i) {
				p = currentLen - p + 1;
			} else if (p > oldLen) {
				return '$';
			}
		}
		
		return s.charAt((int) p - 1);
	}
}
