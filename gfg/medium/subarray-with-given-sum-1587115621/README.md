# Indexes of Subarray Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value  **target** .

You need to return the  **1-based** indices of the leftmost and rightmost elements of this subarray.

- You need to find the first subarray whose sum is equal to the target.
- If no such array is possible then, return [-1].

 **Examples:** 

```
Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
```

```
Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.

```

```
Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-06T14:45:34.270Z  

```java

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        
        int low = 0;
        int high = 0;
        int sum = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(high = 0; high < arr.length; high++){
            sum = sum + arr[high];
            while(sum > target){
                sum = sum - arr[low];
                low++;
            }
            if(sum == target && low <= high){
                res.add((low + 1));
                res.add((high + 1));
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1)