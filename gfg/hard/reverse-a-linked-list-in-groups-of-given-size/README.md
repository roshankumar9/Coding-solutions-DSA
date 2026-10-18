# Linked List Group Reverse

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a Singly linked list, reverse every  **k**  node in the linked list and return the head of the modified list. If the node count is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

 **Examples:** 

```
Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.

```

```
Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 4,

Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-18T19:54:24.172Z  

```java
/* Structure of linked list Node
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/

class Solution {
    public void reverse(Node head, int times){
        Node cur = head;
        Node prev = null;
        while(times != 0){
            times--;
            Node nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return;
    }
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null) return head;
        Node res = null;
        Node left = head;
        Node prevLeft = null;
        while(true){
            Node right = left;
            for(int i = 0; i < k - 1; i++){
                if(right == null) break;
                right = right.next;
            }
            if(right != null){
                Node nextLeft = right.next;
                reverse(left, k);
                
                if(prevLeft != null)
                    prevLeft.next = right;
                    
                prevLeft = left;
                left = nextLeft;
                
                if(res == null)
                    res = right;
                    
                if(left == null) break;
            } else {
                int count = 1;
                right = left;
                while(right != null && right.next != null){
                    count++;
                    right = right.next;
                }
                reverse(left, count);
                
                if(prevLeft != null)
                    prevLeft.next = right;
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

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1)