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
        return dummy.next;
    }
}

// class Solution {
//     public long reverse(long n){
//         long rev = 0;
//         while(n != 0){
//             int d = (int) n % 10;
//             rev = rev * 10 + d;
//             n = n / 10;
//         }
//         return rev;
//     }
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//         long n1 = 0;
//         while(l1 != null){
//             n1 = n1 * 10 + l1.val;
//             l1 = l1.next;
//         }
//         long n2 = 0;
//         while(l2 != null){
//             n2 = n2 * 10 + l2.val;
//             l2 = l2.next;
//         }
//         n1 = reverse(n1);
//         n2 = reverse(n2);
//         long sum = n1 + n2;

//         ListNode dummy = new ListNode(0);
//         ListNode temp = dummy;
//         if(sum == 0) return dummy;
//         while(sum != 0){
//             int d = (int)sum % 10;
//             temp.next = new ListNode(d);
//             temp = temp.next;
//             sum = sum / 10;
//         }
//         return dummy.next;
//     }
// }