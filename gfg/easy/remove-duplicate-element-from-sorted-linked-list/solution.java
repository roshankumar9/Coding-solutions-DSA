/* Structure of linked list Node
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
    Node removeDuplicates(Node head) {
        // code here
        if(head == null || head.next == null) return head;
        Node res = head;
        Node prev = head;
        Node cur = head.next;
        while(cur != null){
            while(cur != null && cur.data == prev.data){
                cur = cur.next;
            }
            if(cur == null){
                prev.next = cur;
                return res;
            }
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        return res;
    }
}