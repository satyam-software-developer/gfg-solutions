class Solution {
    public int findMax(int n) {
        int best = n;
        int maxSum = digitSum(n);

        for (int p = 1; p <= n; p *= 10) {
            int candidate = (n / p - 1) * p + (p - 1);

            if (candidate >= 1) {
                int sum = digitSum(candidate);

                if (sum > maxSum || (sum == maxSum && candidate > best)) {
                    maxSum = sum;
                    best = candidate;
                }
            }

            if (p > n / 10) {
                break;
            }
        }

        return best;
    }

    private int digitSum(int x) {
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}