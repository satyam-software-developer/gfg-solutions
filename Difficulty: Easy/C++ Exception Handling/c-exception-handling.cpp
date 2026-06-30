class Solution {
	public:
	int maxValue(int a, int b) {
		// code here
		try {
			if (b == 0) {
				throw b;
			}
		} catch (...) {
			return - 999999;
		}
		return max({(a + b), (a - b), (a*b), (a/b)});
		
	}
	
};
