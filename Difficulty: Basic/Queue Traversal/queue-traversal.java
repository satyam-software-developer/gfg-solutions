class Solution {
    public ArrayList<Integer> queueTraversal(Queue<Integer> q) {
        // code here
        ArrayList<Integer> ans =  new ArrayList<>();
        
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
        
    }
}