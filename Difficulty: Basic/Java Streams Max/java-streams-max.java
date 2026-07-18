class Solution {
    public static int maxUsingStreams(int[] arr) {
        // code here
          return java.util.Arrays.stream(arr).max().getAsInt();
        
    }
}