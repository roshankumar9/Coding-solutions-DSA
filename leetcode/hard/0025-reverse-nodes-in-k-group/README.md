# Reverse Nodes in k-Group

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return  *the modified list*.

`k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

 **Example 1:** 

```
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

```

 **Example 2:** 

```
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

```

 

 **Constraints:** 

- The number of nodes in the list is n.
- 1 <= k <= n <= 5000
- 0 <= Node.val <= 1000

 

 **Follow-up:**  Can you solve the problem in `O(1)` extra memory space?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 46.2 MB (beats 86.17%)  
**Submitted:** 2026-10-18T17:50:19.782Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-nodes-in-k-group/)