# Climbing Stairs

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

 

 **Example 1:** 

```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

```

 **Example 2:** 

```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

```

 

 **Constraints:** 

- 1 <= n <= 45

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 1.15%)  
**Memory:** 42.3 MB (beats 17.73%)  
**Submitted:** 2026-10-10T16:32:53.441Z  

```java
class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int fun(int n, int idx){
        if(idx >= n){
            if(n == idx) return 1;
            return 0;
        }
        if(dp.containsKey(idx)) return dp.get(idx);
        int ch1 = fun(n, idx + 1);
        int ch2 = fun(n, idx + 2);
        int ans = ch1 + ch2;
        dp.put(idx, ans);
        return ans;
    }
    public int climbStairs(int n) {
        return fun(n, 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/climbing-stairs/)