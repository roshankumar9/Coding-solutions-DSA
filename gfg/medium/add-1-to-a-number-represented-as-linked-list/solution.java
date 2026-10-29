/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        while(cur != null){
            Node nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node temp = head;
        Node dummy = new Node(0);
        Node res = dummy;
        int carry = 1;
        while(temp != null){
            int sum = temp.data + carry;
            int node = sum % 10;
            carry = sum / 10;
            dummy.next = new Node(node);
            dummy = dummy.next;
            temp = temp.next;
        }
        if(carry != 0){
            dummy.next = new Node(carry);
        }
        return reverse(res.next);
    }
}