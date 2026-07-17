class Solution {
    public int dayBefore(int d, int n) {
        // code here
         return (d - (n % 7) + 7) % 7;
        
    }
}