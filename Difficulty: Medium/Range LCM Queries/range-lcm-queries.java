import java.util.*;

class Solution {
    long[] segTree;
    int n;

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        n = arr.length;
        segTree = new long[4 * n];

        build(0, 0, n - 1, arr);

        ArrayList<Long> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                update(0, 0, n - 1, q[1], q[2]);
            } else {
                ans.add(query(0, 0, n - 1, q[1], q[2]));
            }
        }

        return ans;
    }

    void build(int node, int start, int end, int[] arr) {
        if (start == end) {
            segTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid, arr);
        build(2 * node + 2, mid + 1, end, arr);

        segTree[node] = lcm(segTree[2 * node + 1], segTree[2 * node + 2]);
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            segTree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, end, idx, val);
        }

        segTree[node] = lcm(segTree[2 * node + 1], segTree[2 * node + 2]);
    }

    long query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 1;
        }

        if (l <= start && end <= r) {
            return segTree[node];
        }

        int mid = (start + end) / 2;

        long left = query(2 * node + 1, start, mid, l, r);
        long right = query(2 * node + 2, mid + 1, end, l, r);

        return lcm(left, right);
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}