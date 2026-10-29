# Add 1 to a Linked List Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given head of a linked list where each node contains a single digit. The digits together represent a number formed by concatenating the node values in order. Add 1 to this number and return the head of the modified linked list.

 **Examples :** 

```
Input: Head: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 

```

```
Input: Head: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
```

```
Input: Head: 0->0->1
Output: 002
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T15:21:00.922Z  

```java
/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        while(cur != null){
            Node nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node temp = head;
        Node dummy = new Node(0);
        Node res = dummy;
        int carry = 1;
        while(temp != null){
            int sum = temp.data + carry;
            int node = sum % 10;
            carry = sum / 10;
            dummy.next = new Node(node);
            dummy = dummy.next;
            temp = temp.next;
        }
        if(carry != 0){
            dummy.next = new Node(carry);
        }
        return reverse(res.next);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1)