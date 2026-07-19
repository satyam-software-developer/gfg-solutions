/*
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}
*/

class Solution {
    void printList(Node head) {
        // code here
        Node current = head;
        
        while(current != null){
            
            System.out.print(current.data + " ");
            
            current = current.next;
        }
    }
}