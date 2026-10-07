# Add Two Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two  **non-empty**  linked lists representing two non-negative integers. The digits are stored in  **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

 **Example 1:** 

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

```

 **Example 2:** 

```
Input: l1 = [0], l2 = [0]
Output: [0]

```

 **Example 3:** 

```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

```

 

 **Constraints:** 

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 46.4 MB (beats 76.60%)  
**Submitted:** 2026-10-07T12:30:45.729Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/add-two-numbers/)