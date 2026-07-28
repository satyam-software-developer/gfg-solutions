class Solution {
    public static LinkedList<Integer> insertion(int arr[]) {
        // Your code here
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int num : arr){
            list.add(num);
        }
        
        return list;
    }
}