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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow.next);
        slow.next = null;

        while(right != null) {
            ListNode nextLeft = left.next;
            ListNode nextRight = right.next;

            left.next = right;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }
}