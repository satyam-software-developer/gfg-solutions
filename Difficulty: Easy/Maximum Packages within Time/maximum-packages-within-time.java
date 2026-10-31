class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int sum = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            if (right - left + 1 > totalTime) {
                sum -= arr[left];
                left++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}