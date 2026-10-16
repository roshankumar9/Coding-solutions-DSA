# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, find the length of the  **longest**   **substring**  without duplicate characters.

 

 **Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

```

 **Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

```

 **Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

 

 **Constraints:** 

- 0 <= s.length <= 105
- s consists of English letters, digits, symbols and spaces.

## Solution

**Language:** Java  
**Runtime:** 74 ms (beats 18.13%)  
**Memory:** 47.2 MB (beats 98.85%)  
**Submitted:** 2026-10-16T16:08:35.982Z  

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int res = 0;
        for(int high = 0; high < s.length(); high++){
            char c = s.charAt(high);
            int len = high - low + 1;
            map.put(c,map.getOrDefault(c, 0) + 1);
            while(map.size() < len){
                char lc = s.charAt(low);
                map.put(lc, map.getOrDefault(lc, 0) - 1);
                if(map.get(lc) == 0)
                    map.remove(lc);
                low++;
                len = high - low + 1;
            }
            res = Math.max(len, res);
        }
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)