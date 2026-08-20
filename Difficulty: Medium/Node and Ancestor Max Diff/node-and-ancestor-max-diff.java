/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiff(Node root) {
        int[] result = {Integer.MIN_VALUE};
        findMin(root, result);
        return result[0];
    }

    int findMin(Node node, int[] result) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int leftMin = findMin(node.left, result);
        int rightMin = findMin(node.right, result);

        int minDescendant = Math.min(leftMin, rightMin);

        result[0] = Math.max(result[0], node.data - minDescendant);

        return Math.min(node.data, minDescendant);
    }
}