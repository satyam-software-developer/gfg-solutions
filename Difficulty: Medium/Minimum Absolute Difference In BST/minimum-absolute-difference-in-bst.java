/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int absDiff(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int prev = -1;
        int ans = Integer.MAX_VALUE;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != -1) {
                ans = Math.min(ans, curr.data - prev);
            }

            prev = curr.data;
            curr = curr.right;
        }

        return ans;
    }
}