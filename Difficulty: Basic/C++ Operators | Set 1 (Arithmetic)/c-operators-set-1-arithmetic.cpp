class Solution {
	public:
	vector<int> cppOperators(int A, int B) {
		// code here
		
		vector<int> ans;
		
		ans.push_back(A + B);
		ans.push_back(A * B);
		ans.push_back(abs(A - B));
		ans.push_back(max(A, B) / min(A, B));
		
		return ans;
	}
};
