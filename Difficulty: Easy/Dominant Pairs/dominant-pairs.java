class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length / 2;
        int[] second = new int[n];

        for (int i = 0; i < n; i++) {
            second[i] = arr[n + i];
        }

        Arrays.sort(second);

        int count = 0;

        for (int i = 0; i < n; i++) {
            long target = (long) arr[i] / 5;
            int low = 0, high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if ((long) second[mid] * 5 <= arr[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            count += low;
        }

        return count;
    }
}