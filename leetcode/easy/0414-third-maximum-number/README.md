# Third Maximum Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Cognizant
Nvidia
Amazon
Goldman Sachs
tcs

You are given an integer array `nums`.

Return the  **third distinct maximum**  number in this array. If the third  **maximum**  does not exist, return the  **maximum**  number.

 

 **Example 1:** 

```
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

```

 **Example 2:** 

```
Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

```

 **Example 3:** 

```
Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

 

 **Follow up:**  Can you find an `O(n)` solution?

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 41.3 MB  
**Submitted:** 2026-10-22T15:53:46.084Z  

```java
class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(first < nums[i]){
                third = second;
                second = first;
                first = nums[i];
            } else if(second <= nums[i] && nums[i] != first){
                third = second;
                second = nums[i];
            } else {
                third = nums[i];
            }
        }
        return third == Integer.MIN_VALUE ? first : third;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/third-maximum-number/)