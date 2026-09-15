/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        int[] count = new int[100005];
        java.util.Queue<Node> q = new java.util.LinkedList<>();
        java.util.Queue<Integer> level = new java.util.LinkedList<>();

        q.offer(root);
        level.offer(1);

        while (!q.isEmpty()) {
            Node node = q.poll();
            int l = level.poll();

            if (node.left == null && node.right == null) {
                count[l]++;
            }

            if (node.left != null) {
                q.offer(node.left);
                level.offer(l + 1);
            }

            if (node.right != null) {
                q.offer(node.right);
                level.offer(l + 1);
            }
        }

        int ans = 0;

        for (int l = 1; l < count.length && k >= l; l++) {
            int take = Math.min(count[l], k / l);
            ans += take;
            k -= take * l;
        }

        return ans;
    }
}