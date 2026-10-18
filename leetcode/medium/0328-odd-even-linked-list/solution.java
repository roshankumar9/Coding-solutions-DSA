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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode con = null;
        while((odd != null && odd.next != null) || (even != null)){
            if(con == null)
                con = even;
            if(even.next == null) break;
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = con;
        return head;
    }
}