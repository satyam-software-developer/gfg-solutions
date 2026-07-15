#include <vector>
#include <numeric>

using namespace std;

class Solution {
  public:
    // DSU Class with Iterative Find (Prevents Stack Overflow)
    struct DSU {
        vector<int> parent;
        vector<int> rank;
        int components;

        DSU(int n) {
            parent.resize(n + 1);
            rank.resize(n + 1, 0);
            iota(parent.begin(), parent.end(), 0);
            components = n;
        }

        // Iterative path compression
        int find(int i) {
            if (parent[i] == i) return i;
            
            int root = i;
            while (root != parent[root]) {
                root = parent[root];
            }
            
            int curr = i;
            while (curr != root) {
                int next = parent[curr];
                parent[curr] = root;
                curr = next;
            }
            return root;
        }

        void unite(int i, int j) {
            int root_i = find(i);
            int root_j = find(j);
            if (root_i != root_j) {
                if (rank[root_i] < rank[root_j])
                    parent[root_i] = root_j;
                else if (rank[root_i] > rank[root_j])
                    parent[root_j] = root_i;
                else {
                    parent[root_i] = root_j;
                    rank[root_j]++;
                }
                components--;
            }
        }
    };

    int findComponents(int n, int m, vector<vector<int>> query) {
        // diff[d][i] stores the sweep-line markers for step 'd' at index 'i'
        // We use size n + 1 to handle 1-based indexing safely.
        vector<vector<int>> diff(11, vector<int>(n + 1, 0));

        // 1. Mark ranges in Difference Arrays
        for (const auto& q : query) {
            int a = q[0];
            int d = q[1];
            int k = q[2];

            if (k <= 0) continue;

            // Start a chain of connections at index 'a' for step 'd'
            diff[d][a]++;
            
            // The chain connects (a) -> (a+d) ... -> (a+kd)
            // We need unions for indices: a, a+d, ..., a+(k-1)d
            // The 'active' status should stop forcing connections at index a + k*d
            long long end_idx = (long long)a + (long long)k * d;
            
            if (end_idx <= n) {
                diff[d][end_idx]--;
            }
        }

        DSU dsu(n);

        // 2. Process each difference 'd' (1 to 10) independently
        for (int d = 1; d <= 10; ++d) {
            // We must sweep each "remainder class" separately.
            // e.g. for d=2, we sweep 1->3->5... and 2->4->6...
            for (int start = 1; start <= d && start <= n; ++start) {
                int active = 0;
                
                // Jump through the universe with step 'd'
                for (int i = start; i <= n; i += d) {
                    active += diff[d][i];
                    
                    // If we are inside an active query range, connect i to i+d
                    if (active > 0) {
                        if (i + d <= n) {
                            dsu.unite(i, i + d);
                        }
                    }
                }
            }
        }

        return dsu.components;
    }
};