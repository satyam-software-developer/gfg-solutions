/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

import java.util.*;

class Solution {
    int preIndex;
    HashMap<Integer, Integer> map;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        map = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int l, int h) {
        if (preIndex >= pre.length || l > h)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (l == h || preIndex >= pre.length)
            return root;

        int i = map.get(pre[preIndex]);

        if (i <= h) {
            root.left = build(pre, i, h);
            root.right = build(pre, l + 1, i - 1);
        }

        return root;
    }
}