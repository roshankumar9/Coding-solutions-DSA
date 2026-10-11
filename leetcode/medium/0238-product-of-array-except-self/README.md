# Product of Array Except Self

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return  *an array*  `answer`  *such that*  `answer[i]`  *is equal to the product of all the elements of*  `nums`  *except*  `nums[i]`.

The product of any prefix or suffix of `nums` is  **guaranteed**  to fit in a  **32-bit**  integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

 

 **Example 1:** 

```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

```

 **Example 2:** 

```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

 

 **Follow up:**  Can you solve the problem in `O(1)` extra space complexity? (The output array  **does not**  count as extra space for space complexity analysis.)

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 22.28%)  
**Memory:** 63.5 MB (beats 97.11%)  
**Submitted:** 2026-10-11T15:36:30.151Z  

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
        int i = 1;
        int j = n - 2;
        while(i != n){
            pre[i] = nums[i - 1] * pre[i - 1];
            i++;
            suf[j] = suf[j + 1] * nums[j + 1];
            j--;
        }
        int x = 0;
        while(x != n){
            int val = pre[x] * suf[x];
            nums[x] = val;
            x++;
        }
        return nums;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/product-of-array-except-self/)