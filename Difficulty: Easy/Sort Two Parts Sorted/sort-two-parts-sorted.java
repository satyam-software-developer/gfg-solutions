class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            return;
        }

        int[] result = new int[n];
        int i = 0, j = breakPoint, k = 0;

        while (i < breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }

        while (i < breakPoint) {
            result[k++] = arr[i++];
        }

        while (j < n) {
            result[k++] = arr[j++];
        }

        System.arraycopy(result, 0, arr, 0, n);
    }
}