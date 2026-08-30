class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = l.length;

        long[] prefix = new long[n];

        for (int i = 0; i < n; i++) {
            long count = (long) r[i] - l[i] + 1;
            prefix[i] = count + (i == 0 ? 0 : prefix[i - 1]);
        }

        for (int k : rank) {
            int low = 0;
            int high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int idx = low;
            long before = idx == 0 ? 0 : prefix[idx - 1];
            long offset = k - before - 1;

            ans.add((int) (l[idx] + offset));
        }

        return ans;
    }
}