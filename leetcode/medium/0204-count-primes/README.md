# Count Primes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Intel
Epic Systems
Accenture
SAP
Citadel

Given an integer `n`, return  *the number of prime numbers that are strictly less than*  `n`.

 

 **Example 1:** 

```
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

```

 **Example 2:** 

```
Input: n = 0
Output: 0

```

 **Example 3:** 

```
Input: n = 1
Output: 0

```

 

 **Constraints:** 

- 0 <= n <= 5 * 106

## Solution

**Language:** Java  
**Runtime:** 1180 ms  
**Memory:** 41 MB  
**Submitted:** 2026-10-22T07:42:48.771Z  

```java
class Solution {
    public boolean prime(int n){
        int fact = 0;
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0)
                fact++;
            if(fact > 1)
                return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
            if(prime(i))
                count++;
        }
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-primes/)