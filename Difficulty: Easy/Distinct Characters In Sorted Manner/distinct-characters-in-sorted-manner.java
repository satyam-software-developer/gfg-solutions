class Solution {
    public String sortedDistinct(String s) {
        // code here
         boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i) - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                ans.append((char) (i + 'a'));
            }
        }

        return ans.toString();
    }
}
