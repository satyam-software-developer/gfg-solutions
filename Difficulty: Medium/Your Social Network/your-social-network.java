import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length + 1;

        for (int i = 2; i <= n; i++) {
            int current = i;
            int distance = 1;

            while (current != 1) {
                current = arr[current - 2];

                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(current);
                list.add(distance);
                result.add(list);

                distance++;
            }
        }

        result.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return Integer.compare(a.get(1), b.get(1));
        });

        return result;
    }
}