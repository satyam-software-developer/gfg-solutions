import java.util.*;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int maxSum(int n) {
        if (n == 0) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = Math.max(n,
                maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4));

        map.put(n, ans);

        return ans;
    }
}