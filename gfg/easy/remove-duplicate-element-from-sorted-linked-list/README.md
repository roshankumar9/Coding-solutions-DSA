# Remove Duplicates in Sorted Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the head of a sorted singly linked list, remove all duplicate nodes so that each element appears only once. The resulting linked list should remain sorted.

 **Note:**  Try to solve the problem without using extra space.

 **Examples:** 

```
Input: Head: 2 -> 2 -> 4 -> 5
Output: 2 -> 4 -> 5

Explanation: In the given linked list 2 -> 2 -> 4 -> 5, only 2 occurs more than 1 time. So we need to remove it once.

```

```
Input: Head: 2 -> 2 -> 2 -> 2 -> 2
Output: 2

Explanation: In the given linked list  2 -> 2 -> 2 -> 2, 2 is the only element and is repeated 5 times. So we need to remove any four 2.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T15:37:18.788Z  

```java
/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // code here
        if(head == null || head.next == null) return head;
        Node res = head;
        Node prev = head;
        Node cur = head.next;
        while(cur != null){
            while(cur != null && cur.data == prev.data){
                cur = cur.next;
            }
            if(cur == null){
                prev.next = cur;
                return res;
            }
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1)