class Solution {
	public:
	int hopscotch(vector<vector<int>> mat, int d, int i, int j) {
		
		int n = mat.size();
		int m = mat[0].size();
		
		auto is_valid = [&](int x, int y) {
			return x >= 0 && x < n && y >= 0 && y < m;
		};
		
		int res = 0;
		
		if (d == 0) {
			if ((j + 1) % 2 == 0) {
				
				if (is_valid(i, j - 1))
					res += mat[i][j - 1];
				if (is_valid(i, j + 1))
					res += mat[i][j + 1];
				if (is_valid(i - 1, j))
					res += mat[i - 1][j];
				if (is_valid(i + 1, j))
					res += mat[i + 1][j];
				if (is_valid(i + 1, j - 1))
					res += mat[i + 1][j - 1];
				if (is_valid(i + 1, j + 1))
					res += mat[i + 1][j + 1];
				
			} else {
				
				if (is_valid(i, j - 1))
					res += mat[i][j - 1];
				if (is_valid(i, j + 1))
					res += mat[i][j + 1];
				if (is_valid(i - 1, j))
					res += mat[i - 1][j];
				if (is_valid(i + 1, j))
					res += mat[i + 1][j];
				if (is_valid(i - 1, j + 1))
					res += mat[i - 1][j + 1];
				if (is_valid(i - 1, j - 1))
					res += mat[i - 1][j - 1];
			}
		}
		else {
			
			if ((j + 1) % 2 == 0) {
				
				if (is_valid(i - 1, j - 1))
					res += mat[i - 1][j - 1];
				if (is_valid(i - 2, j))
					res += mat[i - 2][j];
				if (is_valid(i - 1, j + 1))
					res += mat[i - 1][j + 1];
				if (is_valid(i - 1, j + 2))
					res += mat[i - 1][j + 2];
				if (is_valid(i, j + 2))
					res += mat[i][j + 2];
				if (is_valid(i + 1, j + 2))
					res += mat[i + 1][j + 2];
				if (is_valid(i + 2, j + 1))
					res += mat[i + 2][j + 1];
				if (is_valid(i + 2, j))
					res += mat[i + 2][j];
				if (is_valid(i + 2, j - 1))
					res += mat[i + 2][j - 1];
				if (is_valid(i + 1, j - 2))
					res += mat[i + 1][j - 2];
				if (is_valid(i, j - 2))
					res += mat[i][j - 2];
				if (is_valid(i - 1, j - 2))
					res += mat[i - 1][j - 2];
				
			} else {
				
				if (is_valid(i - 2, j - 1))
					res += mat[i - 2][j - 1];
				if (is_valid(i - 2, j))
					res += mat[i - 2][j];
				if (is_valid(i - 2, j + 1))
					res += mat[i - 2][j + 1];
				if (is_valid(i - 1, j + 2))
					res += mat[i - 1][j + 2];
				if (is_valid(i, j + 2))
					res += mat[i][j + 2];
				if (is_valid(i + 1, j + 2))
					res += mat[i + 1][j + 2];
				if (is_valid(i + 1, j + 1))
					res += mat[i + 1][j + 1];
				if (is_valid(i + 2, j))
					res += mat[i + 2][j];
				if (is_valid(i + 1, j - 1))
					res += mat[i + 1][j - 1];
				if (is_valid(i + 1, j - 2))
					res += mat[i + 1][j - 2];
				if (is_valid(i, j - 2))
					res += mat[i][j - 2];
				if (is_valid(i - 1, j - 2))
					res += mat[i - 1][j - 2];
			}
		}
		
		return res;
	}
};
