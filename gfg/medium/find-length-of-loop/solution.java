/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        if(head == null) return 0;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                break;
            }
        }
        if(slow != fast || fast.next == null) return 0; // no cycle.
        int res = 1;
        fast = fast.next;
        while(fast != slow){
            fast = fast.next;
            res++;
        }
        return res;
    }
}