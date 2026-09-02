class Solution {
    public int solve(int n, String s) {
        boolean[] inside = new boolean[26];
        boolean[] rejected = new boolean[26];
        int available = n;
        int answer = 0;

        for (char ch : s.toCharArray()) {
            int id = ch - 'A';

            if (!inside[id] && !rejected[id]) {
                if (available > 0) {
                    inside[id] = true;
                    available--;
                } else {
                    rejected[id] = true;
                    answer++;
                }
            } else if (inside[id]) {
                inside[id] = false;
                available++;
            }
        }

        return answer;
    }
}