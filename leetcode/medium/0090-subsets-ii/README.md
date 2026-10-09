# Subsets II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` that may contain duplicates, return  *all possible*   *subsets** (the power set)*.

The solution set  **must not**  contain duplicate subsets. Return the solution in  **any order**.

 

 **Example 1:** 

```
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [[],[0]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 54.05%)  
**Memory:** 45.2 MB (beats 42.25%)  
**Submitted:** 2026-10-09T17:00:18.842Z  

```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void fun(int[] arr, int n, int idx, List<Integer> temp){
        if(n == idx){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[idx]);
        fun(arr, n, idx + 1, temp);
        temp.remove(temp.size() - 1);

        // removing duplicates here.
        while(idx + 1 < n && arr[idx] == arr[idx + 1]){
            idx++;
        }

        fun(arr, n, idx + 1, temp);

        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        fun(nums, n, 0, temp);
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subsets-ii/)