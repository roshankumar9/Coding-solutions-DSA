# Add Number Linked Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the head of two singly linked lists  **head1**  and  **head2**  representing two non-negative integers. You need to return the  **head**  of the linked list representing the  **sum**  of these two numbers.

 **Note:** There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

 **Examples:** 

```
Input: 
    
Output:  1 -> 1 -> 2 -> 2
Explanation: Given numbers are 123 and 999. There sum is 1122.
    

```

```
Input: 
    
Output: 7 -> 0 
Explanation: Given numbers are 63 and 7. There sum is 70.
    
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-23T16:03:04.923Z  

```java
/*
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
    public Node reverse(Node head){
        Node prev = null;
        while(head != null){
            Node nex = head.next;
            head.next = prev;
            prev = head;
            head = nex;
        }
        return prev;
    }
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;

        while(head1 != null || head2 != null || carry != 0){
            int val1 = head1 != null ? head1.data : 0;
            int val2 = head2 != null ? head2.data : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
            
            tail.next = new Node(sum);
            tail = tail.next;
        }
        
        Node res = reverse(dummy.next);
        
        // removing leading zeros.
        while(res != null && res.data == 0 && res.next != null){
            res = res.next;
        }
        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1)