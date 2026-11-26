class Solution {
  public ArrayList<Integer> countVowels(String s, int[][] queries) {
    int n = s.length();
    int[] prefix = new int[n + 1];

    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i];
      if ("aeiou".indexOf(s.charAt(i)) != -1) {
        prefix[i + 1]++;
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int[] q : queries) {
      int l = q[0];
      int r = q[1];
      ans.add(prefix[r + 1] - prefix[l]);
    }

    return ans;
  }
}