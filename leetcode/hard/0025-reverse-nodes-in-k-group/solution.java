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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode res = null;
        ListNode left = head;
        ListNode prevLeft = null;
        while(true){
            ListNode right = left;
            for(int i = 0; i < (k - 1); i++){
                if(right == null) break;
                right = right.next;
            }
            // we got a right
            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left, k);
                if(prevLeft != null)
                    prevLeft.next = right;
                prevLeft = left;
                left = nextLeft;
                if(res == null)
                    res = right;
            } else {
                if(prevLeft != null)
                    prevLeft.next = left;
                if(res == null)
                    res = left;
                break;
            }
        }
        return res;
    }
}