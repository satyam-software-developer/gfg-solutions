/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        java.util.List<Character> pathP = new java.util.ArrayList<>();
        java.util.List<Character> pathQ = new java.util.ArrayList<>();

        if (!findPath(root, p, pathP) || !findPath(root, q, pathQ)) {
            return -1;
        }

        int i = 0;

        while (i < pathP.size() && i < pathQ.size()
                && pathP.get(i) == pathQ.get(i)) {
            i++;
        }

        java.util.List<Character> path = new java.util.ArrayList<>();

        for (int j = pathP.size() - 1; j >= i; j--) {
            path.add(pathP.get(j));
        }

        for (int j = i; j < pathQ.size(); j++) {
            path.add(pathQ.get(j));
        }

        int turns = 0;

        for (int j = 1; j < path.size(); j++) {
            if (path.get(j) != path.get(j - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }

    private boolean findPath(Node root, int target, java.util.List<Character> path) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        path.add('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        path.add('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }
}