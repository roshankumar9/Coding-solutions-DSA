# Search in Rotated Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There is an integer array `nums` sorted in ascending order (with  **distinct**  values).

Prior to being passed to your function, `nums` is  **possibly left rotated**  at an unknown index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1],..., nums[n-1], nums[0], nums[1],..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,5,6,7]` might be left rotated by `3` indices and become `[4,5,6,7,0,1,2]`.

Given the array `nums`  **after**  the possible rotation and an integer `target`, return  *the index of* `target` *if it is in* `nums` *, or* `-1` *if it is not in* `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

 

 **Example 1:** 

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

```

 **Example 2:** 

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

```

 **Example 3:** 

```
Input: nums = [1], target = 0
Output: -1

```

 

 **Constraints:** 

- 1 <= nums.length <= 5000
- -104 <= nums[i] <= 104
- All values of nums are unique.
- nums is an ascending array that is possibly rotated.
- -104 <= target <= 104

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.1 MB (beats 12.16%)  
**Submitted:** 2026-10-06T14:51:15.811Z  

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while(l <= h){
            int gess = l + (h - l) / 2;
            // gess part 2 me ho tab.
            if(nums[gess] > nums[n - 1]){
                if(nums[gess] == target){
                    return gess;
                } else if(target > nums[gess]) {
                    l = gess + 1;
                } else {
                    if(target < nums[0])
                        l = gess + 1;
                    else
                        h = gess - 1;
                }
            }
            // gess part 1 me ho tab.
            else {
                if(nums[gess] == target){
                    return gess;
                } else if(target < nums[gess]){
                    h = gess - 1;
                } else {
                    if(target > nums[n - 1])
                        h = gess - 1;
                    else 
                        l = gess + 1;
                }
            }
        }
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array/)