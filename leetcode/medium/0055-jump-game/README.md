# Jump Game

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums`. You are initially positioned at the array's  **first index**, and each element in the array represents your maximum jump length at that position.

Return `true` *if you can reach the last index, or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

```

 **Example 2:** 

```
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- 0 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.8 MB  
**Submitted:** 2026-10-10T17:05:33.662Z  

```java
class Solution {
    HashMap<Integer, Boolean> dp = new HashMap<>();
    public boolean fun(int arr[], int n, int idx){
        if(idx >= n){
            return true;
        }
        if(dp.containsKey(idx)) return dp.get(idx);
        dp.put(idx, false);
        boolean res = fun(arr, n, idx + arr[idx]);
        return res;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        return fun(nums, n - 1, 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/jump-game/)