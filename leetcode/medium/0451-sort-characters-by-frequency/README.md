# Sort Characters By Frequency

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, sort it in  **decreasing order**  based on the  **frequency**  of the characters. The  **frequency**  of a character is the number of times it appears in the string.

Return  *the sorted string*. If there are multiple answers, return  *any of them*.

 

 **Example 1:** 

```
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

```

 **Example 2:** 

```
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

```

 **Example 3:** 

```
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

```

 

 **Constraints:** 

- 1 <= s.length <= 5 * 105
- s consists of uppercase and lowercase English letters and digits.

## Solution

**Language:** Java  
**Runtime:** 14 ms (beats 61.28%)  
**Memory:** 45.9 MB (beats 98.99%)  
**Submitted:** 2026-10-21T15:27:19.390Z  

```java
class Pair{
    int first;
    char second;
    Pair(int first, char second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public String frequencySort(String s) {
        // min heap.
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> a.first != b.first ? b.first - a.first : Character.compare(a.second, b.second)
        );
        // frequency count.
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            int frq = e.getValue();
            char c = e.getKey();
            Pair pair = new Pair(frq, c);
            minHeap.add(pair);
        }
        StringBuilder res = new StringBuilder();
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int times = p.first;
            char c = p.second;
            for(int i = 0; i < times; i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sort-characters-by-frequency/)