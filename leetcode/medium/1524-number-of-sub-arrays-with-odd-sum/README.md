# Number of Sub-arrays With Odd Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `arr`, return  *the number of subarrays with an  **odd**  sum*.

Since the answer can be very large, return it modulo `109 + 7`.

 

 **Example 1:** 

```
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

```

 **Example 2:** 

```
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

```

 **Example 3:** 

```
Input: arr = [1,2,3,4,5,6,7]
Output: 16

```

 

 **Constraints:** 

- 1 <= arr.length <= 105
- 1 <= arr[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 77.10%)  
**Memory:** 81.9 MB (beats 62.13%)  
**Submitted:** 2026-10-11T17:56:52.808Z  

```java
class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int res = 0;
        int sum = 0;
        int oddSum = 0;
        int evenSum = 1; //empty subarray is even, so evenSum count is 1 initially.
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum % 2 == 0){
                evenSum++;
                res = (res + oddSum) % MOD;
            } else {
                oddSum++;
                res = (res + evenSum) % MOD;
            }
        }
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)