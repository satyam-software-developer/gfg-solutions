class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] maxReach = new int[26];
        for (int i = 0; i < 26; i++) maxReach[i] = -1;

        int ans = -1;
        boolean hasA = false;

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            int far = i;
            if (c < 25 && maxReach[c + 1] != -1) {
                far = maxReach[c + 1];
            }
            if (far > maxReach[c]) {
                maxReach[c] = far;
            }
            if (c == 0) {
                hasA = true;
                ans = Math.max(ans, far - i);
            }
        }

        return hasA ? ans : -1;
    }
}