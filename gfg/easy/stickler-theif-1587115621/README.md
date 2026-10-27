# Stickler Thief

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot. Given an array,  **arr[]**  where arr[i] represents the amount of money in the i-th house. Find the maximum amount he can loot.

 **Examples:** 

```
Input: arr[] = [6, 7, 1, 3, 8, 2, 4]
Output: 19
Explanation: Maximum amount he can get by looting 1st, 3rd, 5th and 7th house, which is 6 + 1 + 8 + 4 = 19.
```

```
Input: arr[] = [5, 3, 4, 11, 2]
Output: 16
Explanation: Maximum amount he can get by looting 1st and 4th house, which is 5 + 11 = 16.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-27T14:56:00.731Z  

```java
class Solution {
    public int fun(int[] arr, int n, int i, int free, int[][] dp){
        if(i == n) return 0;
        if(dp[i][free] != -1) return dp[i][free];
        if(free == 0){
            int val = fun(arr, n, i + 1, 1, dp);
            dp[i][free] = val;
            return val;
        }
        
        int ch1 = arr[i] + fun(arr, n, i + 1, 0, dp);
        int ch2 = fun(arr, n, i + 1, 1, dp);
        
        int ans = Math.max(ch1, ch2);
        dp[i][free] = ans;
        
        return ans;
    }
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(arr, n, 0, 1, dp);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1)