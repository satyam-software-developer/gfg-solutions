class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";

        for (String word : d) {
            if (word.length() < ans.length()) continue;
            if (word.length() == ans.length() && word.compareTo(ans) >= 0) continue;

            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }

            if (j == word.length()) {
                ans = word;
            }
        }

        return ans;
    }
}