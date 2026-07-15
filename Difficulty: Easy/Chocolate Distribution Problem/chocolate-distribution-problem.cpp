//Back-end complete function Template for C++
// Time: O(n), Space: O(1)
int minDiff(vector<int> &arr, int k) {
    // code here
    sort(arr.begin(), arr.end());
    int n = arr.size();
    int min_diff = INT_MAX;
    for (int i = 0; i <= n - k; i++) {
        min_diff = min(min_diff, arr[i + k - 1] - arr[i]);
    }
    return min_diff;
}