class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] count = new int[n + 1];

        for (int j : updates) {
            count[j]++;
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += count[i];
            arr.add(sum);
        }

        return arr;
    }
}