class Solution {
    public static int binarySearchAL(ArrayList<Integer> list, int k) {
        // Your code here
        int index = Collections.binarySearch(list, k);
        
        // If k in arr return 1, else return -1
        if(index >= 0){
            return index;
        }
        
        return -1;
        
    }
}