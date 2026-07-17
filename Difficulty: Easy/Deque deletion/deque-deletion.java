class Solution {
    public static void eraseAt(ArrayDeque<Integer> deq, int X) {
        // code here
         ArrayDeque<Integer> temp = new ArrayDeque<>();
        int i = 0;
        while (!deq.isEmpty()) {
            int val = deq.pollFirst();
            if (i != X) {
                temp.offerLast(val);
            }
            i++;
        }
        deq.addAll(temp);
    }

    public static void eraseInRange(ArrayDeque<Integer> deq, int start, int end) {
        
        // code here
          if (start == end) {
            return;
        }

        ArrayDeque<Integer> temp = new ArrayDeque<>();
        int i = 0;
        while (!deq.isEmpty()) {
            int val = deq.pollFirst();
            if (i < start || i >= end) {
                temp.offerLast(val);
            }
            i++;
        }
        deq.addAll(temp);
    }

        
    public static void eraseAll(ArrayDeque<Integer> deq) {
        // code here
        deq.clear();
    }
}