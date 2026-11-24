class Solution {
  public ArrayList<Integer> findPairs(int[] arr) {
    int n = arr.length;
    HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = arr[i] + arr[j];
        map.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[] {i, j});
      }
    }

    for (int a = 0; a < n; a++) {
      for (int b = a + 1; b < n; b++) {
        int sum = arr[a] + arr[b];
        ArrayList<int[]> pairs = map.get(sum);

        for (int[] p : pairs) {
          int c = p[0];
          int d = p[1];

          if (a == c && b == d)
            continue;

          if (a != c && a != d && b != c && b != d) {
            if (a < c || (a == c && b < d)) {
              return new ArrayList<>(Arrays.asList(a, b, c, d));
            }
          }
        }
      }
    }

    return new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
  }
}