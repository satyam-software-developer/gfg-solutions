class Solution {
    public boolean balancePan(int a, int b) {
        while (b > 0) {
            long remainder = b % a;

            if (remainder == 1) {
                b--;
            } else if (remainder == a - 1) {
                b++;
            } else if (remainder == 0) {
                b /= a;
            } else {
                return false;
            }

            if (b == 0) {
                return true;
            }

            if (b % a == 0) {
                b /= a;
            }
        }

        return true;
    }
}