import java.util.*;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int n = a.length;
        int m = b.length;
        
        int[] lps = new int[m];
        
        int len = 0;
        int i = 1;
        
        while (i < m) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        int x = 0;
        int y = 0;
        
        while (x < n) {
            if (a[x] == b[y]) {
                x++;
                y++;
            }
            
            if (y == m) {
                res.add(x - y);
                y = lps[y - 1];
            } else if (x < n && a[x] != b[y]) {
                if (y != 0) {
                    y = lps[y - 1];
                } else {
                    x++;
                }
            }
        }
        
        return res;
    }
}