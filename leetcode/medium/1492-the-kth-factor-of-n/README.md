# The kth Factor of n

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Expedia
Amazon
Google
Oracle
Microsoft

You are given two positive integers `n` and `k`. A factor of an integer `n` is defined as an integer `i` where `n % i == 0`.

Consider a list of all factors of `n` sorted in  **ascending order**, return  *the* `kth` *factor*  in this list or return `-1` if `n` has less than `k` factors.

 

 **Example 1:** 

```
Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.

```

 **Example 2:** 

```
Input: n = 7, k = 2
Output: 7
Explanation: Factors list is [1, 7], the 2nd factor is 7.

```

 **Example 3:** 

```
Input: n = 4, k = 4
Output: -1
Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.

```

 

 **Constraints:** 

- 1 <= k <= n <= 1000

 

 **Follow up:** 

Could you solve this problem in less than O(n) complexity?

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 32.96%)  
**Memory:** 41.7 MB (beats 96.71%)  
**Submitted:** 2026-10-22T15:02:24.260Z  

```java
class Solution {
    public int kthFactor(int n, int k) {
        int res = -1;
        List<Integer> fact = new ArrayList<>();
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0)
                fact.add(i);
        }
        fact.add(n);
        if(k <= fact.size()) return fact.get(k - 1);
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/the-kth-factor-of-n/)