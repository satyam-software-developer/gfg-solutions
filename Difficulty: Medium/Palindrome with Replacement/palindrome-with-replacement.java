class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int m = (n + 1) / 2;
        char[] arr = s.toCharArray();
        int sum = 0;
        char prev = 0;

        for (int i = 0; i < m; i++) {
            int j = n - 1 - i;

            if (arr[i] != '?' && arr[j] != '?' && arr[i] != arr[j]) {
                return -1;
            }

            char c = arr[i] != '?' ? arr[i] : arr[j];

            if (c != '?') {
                if (prev != 0) {
                    sum += Math.abs(c - prev);
                }
                prev = c;
            }
        }

        return sum * 2;
    }
}