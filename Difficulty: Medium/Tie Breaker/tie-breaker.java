import java.util.*;

class Solution {
    public String tieBreak(String arr[]) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : arr) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        String ans = "";
        int maxVotes = 0;

        for (String name : map.keySet()) {
            int votes = map.get(name);

            if (votes > maxVotes) {
                maxVotes = votes;
                ans = name;
            } else if (votes == maxVotes && name.compareTo(ans) < 0) {
                ans = name;
            }
        }

        return ans;
    }
}