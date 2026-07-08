vector<char> sortArray(vector<int>& a, vector<char>& b) {
	vector<pair<int, char>> v;
	
	for (int i = 0; i < a.size(); i++) {
		v.push_back({a[i], b[i]});
	}
	
	sort(v.begin(), v.end());
	
	vector<char> ans;
	for (int i = 0; i < v.size(); i++) {
		ans.push_back(v[i].second);
	}
	
	return ans;
}
