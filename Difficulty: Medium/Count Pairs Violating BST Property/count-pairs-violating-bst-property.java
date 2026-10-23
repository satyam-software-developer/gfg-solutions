/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int pairsViolatingBST(Node root) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        inorder(root, values);
        return countInversions(values, 0, values.size() - 1);
    }

    private void inorder(Node root, java.util.List<Integer> values) {
        if (root == null) {
            return;
        }
        inorder(root.left, values);
        values.add(root.data);
        inorder(root.right, values);
    }

    private int countInversions(java.util.List<Integer> values, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = countInversions(values, left, mid);
        count += countInversions(values, mid + 1, right);
        count += merge(values, left, mid, right);

        return count;
    }

    private int merge(java.util.List<Integer> values, int left, int mid, int right) {
        java.util.List<Integer> temp = new java.util.ArrayList<>();
        int i = left;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j <= right) {
            if (values.get(i) <= values.get(j)) {
                temp.add(values.get(i++));
            } else {
                temp.add(values.get(j++));
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp.add(values.get(i++));
        }

        while (j <= right) {
            temp.add(values.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            values.set(left + k, temp.get(k));
        }

        return count;
    }
}