# Kth Largest Element in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Pocket Gems
Avito
Meta
Spotify
Apple

Given an integer array `nums` and an integer `k`, return  *the*  `kth`  *largest element in the array*.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

Can you solve it without sorting?

 

 **Example 1:** 

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

```

 **Example 2:** 

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

```

 

 **Constraints:** 

- 1 <= k <= nums.length <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 157 ms (beats 6.13%)  
**Memory:** 75.3 MB (beats 36.01%)  
**Submitted:** 2026-10-22T07:52:17.950Z  

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            maxHeap.add(nums[i]);
        }
        while(k != 1){
            k--;
            maxHeap.poll();
        }
        return maxHeap.peek();
        
        // for(int i = 0; i < k; i++){
        //     minHeap.add(nums[i]);
        // }

        // for(int i = k; i < nums.length; i++){
        //     if(minHeap.peek() <= nums[i]){
        //         minHeap.poll();
        //         minHeap.add(nums[i]);
        //     }
        // }
        // return minHeap.peek();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/)