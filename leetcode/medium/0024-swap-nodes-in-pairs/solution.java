/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reverse(ListNode head, int times){
        ListNode cur = head;
        ListNode prev = null;
        while(times != 0){
            times--;
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode left = head;
        ListNode prevLeft = null;
        ListNode res = null;
        int k = 2;
        while(true){
            ListNode right = left;
            for(int i = 0; i < (k - 1); i++){
                if(right == null) break;
                right = right.next;
            }
            // we got a right and left
            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left, k);
                if(prevLeft != null)
                    prevLeft.next = right;
                    
                prevLeft = left; // connecting list after swaping.
                left = nextLeft; // for next iteration.

                if(res == null)
                    res = right; // after first swap, right will become head.

            } else { // we dont need to swap, because we don't have right, it means we need to connect only.
                if(prevLeft != null)
                    prevLeft.next = left;

                if(res == null) // when we did not swap any node(k > length or remain LL).
                    res = left;
                break;
            }
        }
        return res;
    }
}