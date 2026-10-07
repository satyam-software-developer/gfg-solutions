/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int maxSum;
    boolean hasTwoLeaves;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        hasTwoLeaves = false;

        findMax(root);

        return hasTwoLeaves ? maxSum : -1;
    }

    private int findMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int left = findMax(node.left);
        int right = findMax(node.right);

        if (node.left != null && node.right != null) {
            hasTwoLeaves = true;
            maxSum = Math.max(maxSum, left + node.data + right);

            return node.data + Math.max(left, right);
        }

        if (node.left != null) {
            return node.data + left;
        }

        return node.data + right;
    }
}