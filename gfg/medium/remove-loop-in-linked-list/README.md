# remove-loop-in-linked-list

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-07T04:37:49.742Z  

```java
/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    public static void removeLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                break;
            }
        }
        // if there is no cycle.
        if(slow != head) return;
        // handling last node connected to first node.
        Node prev = null;
        if(fast == head){
            prev = fast;
            fast = fast.next;
            while(fast != head){
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            return;
        }
        
        // handling last node connected to any other node.
        while(fast != slow){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        if(prev != null)
            prev.next = null;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1)