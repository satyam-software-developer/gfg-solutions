template <class T>
T largest(T arr[], int n) {
	
	// code here
	T max = arr[0];
	
	for (int i = 1; i < n; i++) {
		if (arr[i] > max) {
			max = arr[i];
		}
	}
	return max;
}
