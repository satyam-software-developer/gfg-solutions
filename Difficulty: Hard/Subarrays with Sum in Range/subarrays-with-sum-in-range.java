import java.util.*;

class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return (int)(count(arr, r) - count(arr, l - 1));
    }

    private long count(int[] arr, long k) {
        long ans = 0, sum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left++];
            }
            ans += right - left + 1;
        }

        return ans;
    }
}