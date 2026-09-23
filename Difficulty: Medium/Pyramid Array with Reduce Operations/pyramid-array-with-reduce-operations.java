class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long total = 0;

        for (int x : arr) {
            total += x;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = Math.min(arr[0], 1);
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        right[n - 1] = Math.min(arr[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long maxPyramid = 0;

        for (int i = 0; i < n; i++) {
            int height = Math.min(left[i], right[i]);
            maxPyramid = Math.max(maxPyramid, (long) height * height);
        }

        return (int) (total - maxPyramid);
    }
}