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
    public int[] fun(int n1, int n2, int carray){
        int sum = n1 + n2 + carray;
        int d = sum % 10;
        int c = sum / 10;
        return new int[]{d, c};
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        l1 = reverse(l1);
        l2 = reverse(l2);
        while(l1 != null && l2 != null){
            int n1 = l1.val;
            int n2 = l2.val;
            l1 = l1.next;
            l2 = l2.next;
            int[] arr = fun(n1, n2, carry);
            int node = arr[0];
            carry = arr[1];
            temp.next = new ListNode(node);
            temp = temp.next;
        }
        while(l1 != null){
            int n1 = l1.val;
            l1 = l1.next;
            int arr[] = fun(n1, 0, carry);
            int node = arr[0];
            carry = arr[1];
            temp.next = new ListNode(node);
            temp = temp.next;
        }
        while(l2 != null){
            int n2 = l2.val;
            l2 = l2.next;
            int arr[] = fun(0, n2, carry);
            int node = arr[0];
            carry = arr[1];
            temp.next = new ListNode(node);
            temp = temp.next;
        }
        if(carry != 0) temp.next = new ListNode(carry);
        return reverse(dummy.next);
    }
}