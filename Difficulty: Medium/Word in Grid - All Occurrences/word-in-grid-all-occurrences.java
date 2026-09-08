import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != word.charAt(0)) {
                    continue;
                }

                for (int d = 0; d < 8; d++) {
                    int r = i;
                    int c = j;
                    int k;

                    for (k = 1; k < word.length(); k++) {
                        r += dr[d];
                        c += dc[d];

                        if (r < 0 || r >= n || c < 0 || c >= m ||
                            mat[r][c] != word.charAt(k)) {
                            break;
                        }
                    }

                    if (k == word.length()) {
                        ArrayList<Integer> position = new ArrayList<>();
                        position.add(i);
                        position.add(j);
                        result.add(position);
                        break;
                    }
                }
            }
        }

        return result;
    }
}