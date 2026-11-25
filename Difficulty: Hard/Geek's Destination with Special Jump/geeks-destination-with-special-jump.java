class Solution {
  static final long MOD = 1000000007L;

  public int minTime(int a, int b, int d, int l, int r) {
    long v = a - b;

    long normal = d;
    if (d > a) {
      normal += 2L * b * ((d - a + v - 1) / v);
    }

    long lo = d - r;
    long hi = d - l;

    long left = lo;
    long right = hi + 1;

    while (left < right) {
      long mid = left + (right - left) / 2;

      if (jumpTime(mid, a, b, v) < normal) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    long ans = 0;

    if (lo < left) {
      ans = sumTime(lo, left - 1, a, b, v);
    }

    if (left <= hi) {
      ans = (ans + ((hi - left + 1) % MOD) * (normal % MOD)) % MOD;
    }

    return (int)ans;
  }

  private long jumpTime(long h, long a, long b, long v) {
    long q = 0;

    if (h > a) {
      q = (h - a + v - 1) / v;
    }

    return h + 2 * b * q + 1;
  }

  private long sumTime(long L, long R, long a, long b, long v) {
    if (L > R)
      return 0;

    long count = R - L + 1;
    long sum = (L + R) * count / 2;

    long qSum = 0;

    if (R > a) {
      long start = Math.max(L, a + 1);
      long x1 = start - a - 1;
      long x2 = R - a - 1;

      qSum = prefix(x2 + 1, v) - prefix(x1, v);
      qSum += R - start + 1;
    }

    return (count + sum + 2 * b * qSum) % MOD;
  }

  private long prefix(long n, long v) {
    long q = n / v;
    long rem = n % v;

    return v * q * (q - 1) / 2 + q * rem;
  }
}