class Solution {
    public static int filterUsingStreams(int[] arr) {
        // code here
          return Arrays.stream(arr)
                     .filter(num -> num % 2 != 0)
                     .max()
                     .getAsInt();
    }
}