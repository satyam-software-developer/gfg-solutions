class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        long cost = 0;
        
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                int medianIdx = i / 2;
                cost += (long)(arr[i] - arr[medianIdx]);
            }
            ans.add((int)cost);
        }
        
        return ans;
    }
}