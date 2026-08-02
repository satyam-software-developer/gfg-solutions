class Solution {
    public static boolean areEqual(int a[], int b[]) {
        // code here
        // check length
        if(a.length != b.length){
            return false;
        }
        
        // Compare each element
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        
        // all elements are equal
        return true;
    }
}