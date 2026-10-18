# Swap Nodes in Pairs

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

 **Example 1:** 

 **Input:**  head = [1,2,3,4]

 **Output:**  [2,1,4,3]

 **Explanation:** 

 **Example 2:** 

 **Input:**  head = []

 **Output:**  []

 **Example 3:** 

 **Input:**  head = [1]

 **Output:**  [1]

 **Example 4:** 

 **Input:**  head = [1,2,3]

 **Output:**  [2,1,3]

 

 **Constraints:** 

- The number of nodes in the list is in the range [0, 100].
- 0 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.7 MB (beats 93.75%)  
**Submitted:** 2026-10-18T17:40:43.164Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/swap-nodes-in-pairs/)