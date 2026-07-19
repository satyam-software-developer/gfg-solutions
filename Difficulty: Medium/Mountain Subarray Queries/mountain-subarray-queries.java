import java.util.*;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] up = new int[n];
        int[] down = new int[n];

        up[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                up[i] = up[i + 1];
            } else {
                up[i] = i;
            }
        }

        down[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                down[i] = down[i + 1];
            } else {
                down[i] = i;
            }
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            ans.add(down[up[l]] >= r);
        }

        return ans;
    }
}