# Number of 1 Bits

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Box
Verkada
Qualcomm
Apple
Nvidia

Given a positive integer `n`, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

 

 **Example 1:** 

 **Input:**  n = 11

 **Output:**  3

 **Explanation:** 

The input binary string  **1011**  has a total of three set bits.

 **Example 2:** 

 **Input:**  n = 128

 **Output:**  1

 **Explanation:** 

The input binary string  **10000000**  has a total of one set bit.

 **Example 3:** 

 **Input:**  n = 2147483645

 **Output:**  30

 **Explanation:** 

The input binary string  **1111111111111111111111111111101**  has a total of thirty set bits.

 

 **Constraints:** 

- 1 <= n <= 231 - 1

 

 **Follow up:**  If this function is called many times, how would you optimize it?

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 50.00%)  
**Memory:** 41.9 MB (beats 90.28%)  
**Submitted:** 2026-11-04T15:35:18.789Z  

```java
class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n > 0){
            res++;
            n = n & (n - 1); // here we can remove right most one set bit at once, it means we can count set bit also.
        }
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-1-bits/)