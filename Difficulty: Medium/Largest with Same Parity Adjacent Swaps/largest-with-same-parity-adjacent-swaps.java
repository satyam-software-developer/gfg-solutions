class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;

            while (j + 1 < n && (arr[j] + arr[j + 1]) % 2 == 0) {
                j++;
            }

            Arrays.sort(arr, i, j + 1);

            for (int k = j; k >= i; k--) {
                result.add(arr[k]);
            }

            i = j + 1;
        }

        return result;
    }
}