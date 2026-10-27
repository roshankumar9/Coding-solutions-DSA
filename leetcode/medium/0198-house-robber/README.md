# House Robber

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Cisco
Databricks
Grab
Infosys
Datadog

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and  **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return  *the maximum amount of money you can rob tonight  **without alerting the police***.

 

 **Example 1:** 

```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

```

 **Example 2:** 

```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 400

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.3 MB (beats 91.90%)  
**Submitted:** 2026-10-27T14:23:51.816Z  

```java
class Solution {
    public int fun(int[]nums, int n, int idx, int free, int[][] dp){
        if(idx == n) return 0;
        if(dp[idx][free] != -1) return dp[idx][free];
        if(free == 0){
            int val = fun(nums, n, idx + 1, 1, dp);
            dp[idx][free] = val;
            return val;
        }
        int ch1 = nums[idx] + fun(nums, n, idx + 1, 0, dp);
        int ch2 = fun(nums, n, idx + 1, 1, dp);
        int ans = Math.max(ch1, ch2);
        dp[idx][free] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(nums, n, 0, 1, dp);
     }
}
```

---

[View on LeetCode](https://leetcode.com/problems/house-robber/)