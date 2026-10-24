# Sliding Window Maximum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Citadel
Zenefits
Nutanix
Zepto
Aurora

You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return  *the max sliding window*.

 

 **Example 1:** 

```
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

```

 **Example 2:** 

```
Input: nums = [1], k = 1
Output: [1]

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
- 1 <= k <= nums.length

## Solution

**Language:** Java  
**Runtime:** 14 ms  
**Memory:** 53.6 MB  
**Submitted:** 2026-10-24T15:35:17.108Z  

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int low = 0;
        int high = k - 1;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i <= high; i++){
            maxHeap.add(nums[i]);
        }
        res.add(maxHeap.peek());
        high++;
        while(high < nums.length){
            maxHeap.add(nums[high]);
            int max = maxHeap.peek();
            res.add(max);
            if(max <= nums[low]){
                maxHeap.poll();
            }
            low++;
            high++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sliding-window-maximum/)