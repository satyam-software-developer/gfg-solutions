import java.util.Arrays;
class Solution {
    public static int maxToys(int arr[], int k) {
        // Your code here
        Arrays.sort(arr);
        
        int count = 0;
        
        for(int price : arr){
            if(k >= price){
                k -= price;
                count++;
            }else{
                break;
            }
            
        }
        
        return count;
        
    }
}