class Solution {
    public static ArrayList<Integer> fillArrayList(int arr[]) {
        // Your code here
        ArrayList<Integer> list  = new ArrayList<>();
        
        for(int x : arr){
            list.add(x);
        }
        
        return list;
        
    }
}