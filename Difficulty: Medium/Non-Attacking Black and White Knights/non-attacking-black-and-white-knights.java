class Solution {
    public int numOfWays(int n, int m) {
        long total = (long) n * m;
        long placements = total * (total - 1);

        long attacks = 0;
        attacks += 4L * (n - 1) * (m - 2 >= 0 ? m - 2 : 0);
        attacks += 4L * (n - 2 >= 0 ? n - 2 : 0) * (m - 1);

        return (int) (placements - attacks);
    }
}