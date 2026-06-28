// User functiom template for C++

class Solution {
	public:
	int BasicDataType(string s) {
		// code here
		
		// Character
		if (s.length() == 1 && !isdigit(s[0]))
			return 1;
		
		// Float or Double
		int pos = s.find('.');
		if (pos != string::npos) {
			int digitsAfterDecimal = s.length() - pos - 1;
			
			if (digitsAfterDecimal < 6)
				return 4; // float
			else
				return 8; // double
		}
		
		// Integer
		return 4;
	}
};
