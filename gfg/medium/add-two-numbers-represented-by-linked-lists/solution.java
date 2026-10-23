/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head){
        Node prev = null;
        while(head != null){
            Node nex = head.next;
            head.next = prev;
            prev = head;
            head = nex;
        }
        return prev;
    }
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;

        while(head1 != null || head2 != null || carry != 0){
            int val1 = head1 != null ? head1.data : 0;
            int val2 = head2 != null ? head2.data : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
            
            tail.next = new Node(sum);
            tail = tail.next;
        }
        
        Node res = reverse(dummy.next);
        
        // removing leading zeros.
        while(res != null && res.data == 0 && res.next != null){
            res = res.next;
        }
        return res;
    }
}