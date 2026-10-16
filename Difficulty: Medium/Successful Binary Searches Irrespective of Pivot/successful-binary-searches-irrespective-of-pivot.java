class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int count = 0;
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;
        int[] rightMin = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = minRight;
            minRight = Math.min(minRight, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxLeft && arr[i] < rightMin[i]) {
                count++;
            }
            maxLeft = Math.max(maxLeft, arr[i]);
        }

        return count;
    }
}