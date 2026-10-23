# Sender With Largest Word Count

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Google

You have a chat log of `n` messages. You are given two string arrays `messages` and `senders` where `messages[i]` is a  **message**  sent by `senders[i]`.

A  **message**  is list of  **words**  that are separated by a single space with no leading or trailing spaces. The  **word count**  of a sender is the total number of  **words**  sent by the sender. Note that a sender may send more than one message.

Return  *the sender with the  **largest**  word count*. If there is more than one sender with the largest word count, return  *the one with the  **lexicographically largest**  name*.

 **Note:** 

- Uppercase letters come before lowercase letters in lexicographical order.
- "Alice" and "alice" are distinct.

 

 **Example 1:** 

```
Input: messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"], senders = ["Alice","userTwo","userThree","Alice"]
Output: "Alice"
Explanation: Alice sends a total of 2 + 3 = 5 words.
userTwo sends a total of 2 words.
userThree sends a total of 3 words.
Since Alice has the largest word count, we return "Alice".

```

 **Example 2:** 

```
Input: messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
Output: "Charlie"
Explanation: Bob sends a total of 5 words.
Charlie sends a total of 5 words.
Since there is a tie for the largest word count, we return the sender with the lexicographically larger name, Charlie.
```

 

 **Constraints:** 

- n == messages.length == senders.length
- 1 <= n <= 104
- 1 <= messages[i].length <= 100
- 1 <= senders[i].length <= 10
- messages[i] consists of uppercase and lowercase English letters and ' '.
- All the words in messages[i] are separated by a single space.
- messages[i] does not have leading or trailing spaces.
- senders[i] consists of uppercase and lowercase English letters only.

## Solution

**Language:** Java  
**Runtime:** 141 ms (beats 6.11%)  
**Memory:** 65.2 MB (beats 5.68%)  
**Submitted:** 2026-10-23T06:29:22.598Z  

```java
class Pair{
    int count;
    String name;
    Pair(int count, String name){
        this.count = count;
        this.name = name;
    }
}
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = senders.length;
        for(int i = 0; i < n; i++){
            String sender = senders[i];
            int msgCount = messages[i].split("\\s+").length;
            map.put(sender, map.getOrDefault(sender, 0) + msgCount);
        }
        
        // max heap.
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) ->
            a.count != b.count ? b.count - a.count : b.name.compareTo(a.name)
        );

        for(Map.Entry<String, Integer> e : map.entrySet()){
            String sender = e.getKey();
            int msgCount = e.getValue();
            Pair pair = new Pair(msgCount, sender);
            if(maxHeap.isEmpty() || maxHeap.peek().count == msgCount){
                maxHeap.add(pair);
                continue;
            }
            if(maxHeap.peek().count < msgCount){
                maxHeap.poll();
                maxHeap.add(pair);
            }
        }
        return maxHeap.peek().name;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sender-with-largest-word-count/)