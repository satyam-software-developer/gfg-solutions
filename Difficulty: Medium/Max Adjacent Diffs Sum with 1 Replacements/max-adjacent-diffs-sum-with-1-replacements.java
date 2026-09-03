class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        long dpOriginal = 0;
        long dpOne = 0;

        for (int i = 1; i < n; i++) {
            long newOriginal = Math.max(
                dpOriginal + Math.abs(arr[i] - arr[i - 1]),
                dpOne + Math.abs(arr[i] - 1)
            );

            long newOne = Math.max(
                dpOriginal + Math.abs(1 - arr[i - 1]),
                dpOne
            );

            dpOriginal = newOriginal;
            dpOne = newOne;
        }

        return (int) Math.max(dpOriginal, dpOne);
    }
}