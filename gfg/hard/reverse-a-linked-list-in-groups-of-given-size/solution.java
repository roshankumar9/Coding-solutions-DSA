/* Structure of linked list Node
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/

class Solution {
    public void reverse(Node head, int times){
        Node cur = head;
        Node prev = null;
        while(times != 0){
            times--;
            Node nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return;
    }
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null) return head;
        Node res = null;
        Node left = head;
        Node prevLeft = null;
        while(true){
            Node right = left;
            for(int i = 0; i < k - 1; i++){
                if(right == null) break;
                right = right.next;
            }
            if(right != null){
                Node nextLeft = right.next;
                reverse(left, k);
                
                if(prevLeft != null)
                    prevLeft.next = right;
                    
                prevLeft = left;
                left = nextLeft;
                
                if(res == null)
                    res = right;
                    
                if(left == null) break; // if LL exist k size group without remaining less than k.
            } else {
                int count = 1;
                right = left;
                while(right != null && right.next != null){
                    count++;
                    right = right.next;
                }
                reverse(left, count);
                
                if(prevLeft != null)
                    prevLeft.next = right;
                if(res == null)
                    res = left;
                break;
            }
        }
        return res;
    }
}