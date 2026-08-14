class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        long current = s;
        long total = s;
        long[] nums = new long[arr.length + 1];
        nums[0] = s;

        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            current = total + arr[i];
            total += current;

            if (current <= x) {
                nums[count++] = current;
            }
        }

        long remaining = x;

        for (int i = count - 1; i >= 0; i--) {
            if (nums[i] <= remaining) {
                remaining -= nums[i];
            }
        }

        return remaining == 0;
    }
}