# Max Consecutive Ones

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Careem
Accenture
Wipro
Cognizant
Bloomberg

Given a binary array `nums`, return  *the maximum number of consecutive* `1` *'s in the array*.

 

 **Example 1:** 

```
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

```

 **Example 2:** 

```
Input: nums = [1,0,1,1,0,1]
Output: 2

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 98.24%)  
**Memory:** 51.7 MB (beats 98.97%)  
**Submitted:** 2026-10-22T07:34:54.824Z  

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int one = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                res = Math.max(res, one);
                one = 0;
            } else {
                one++;
            }
        }
        res = Math.max(res, one); // if max ones present in last of the array.
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)