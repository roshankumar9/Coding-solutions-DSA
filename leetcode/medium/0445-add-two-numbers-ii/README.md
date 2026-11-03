# Add Two Numbers II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Bloomberg
Microsoft
Nvidia
Pinterest
Oracle

You are given two  **non-empty**  linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

 **Example 1:** 

```
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

```

 **Example 2:** 

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

```

 **Example 3:** 

```
Input: l1 = [0], l2 = [0]
Output: [0]

```

 

 **Constraints:** 

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

 

 **Follow up:**  Could you solve it without reversing the input lists?

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 62.03%)  
**Memory:** 45.9 MB (beats 89.25%)  
**Submitted:** 2026-11-03T16:00:00.696Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/add-two-numbers-ii/)