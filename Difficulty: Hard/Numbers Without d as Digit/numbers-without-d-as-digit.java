class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) return 0;

        char digit = (char) ('0' + d);
        String s = String.valueOf(n);
        int len = s.length();

        long[] pow9 = new long[len + 1];
        pow9[0] = 1;

        for (int i = 1; i <= len; i++) {
            pow9[i] = pow9[i - 1] * 9;
        }

        long count = 0;

        for (int l = 1; l < len; l++) {
            if (d == 0) {
                count += 9 * pow9[l - 1];
            } else {
                count += 8 * pow9[l - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - '0';
            int remaining = len - i - 1;

            if (i == 0) {
                for (int x = 1; x < cur; x++) {
                    if (x != d) {
                        count += pow9[remaining];
                    }
                }
            } else {
                for (int x = 0; x < cur; x++) {
                    if (x != d) {
                        count += pow9[remaining];
                    }
                }
            }

            if (cur == d) {
                return (int) count;
            }
        }

        return (int) (count + 1);
    }
}