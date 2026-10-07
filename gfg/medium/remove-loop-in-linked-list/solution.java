/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    public static void removeLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                break;
            }
        }
        
        // if there is no cycle.
        if(slow != head) return;
        
        // handling last node connected to first node.
        Node prev = null;
        if(fast == head){
            prev = fast;
            fast = fast.next;
            while(fast != head){
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            return;
        }
        
        // handling last node connected to any other node.
        while(fast != slow){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
        return;
    }
}