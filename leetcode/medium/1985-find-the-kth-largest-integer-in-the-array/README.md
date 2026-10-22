# Find the Kth Largest Integer in the Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Google
Meta

You are given an array of strings `nums` and an integer `k`. Each string in `nums` represents an integer without leading zeros.

Return  *the string that represents the* `kth` *** largest integer**  in *`nums`.

 **Note** : Duplicate numbers should be counted distinctly. For example, if `nums` is `["1","2","2"]`, `"2"` is the first largest integer, `"2"` is the second-largest integer, and `"1"` is the third-largest integer.

 

 **Example 1:** 

```
Input: nums = ["3","6","7","10"], k = 4
Output: "3"
Explanation:
The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
The 4th largest integer in nums is "3".

```

 **Example 2:** 

```
Input: nums = ["2","21","12","1"], k = 3
Output: "2"
Explanation:
The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
The 3rd largest integer in nums is "2".

```

 **Example 3:** 

```
Input: nums = ["0","0"], k = 2
Output: "0"
Explanation:
The numbers in nums sorted in non-decreasing order are ["0","0"].
The 2nd largest integer in nums is "0".

```

 

 **Constraints:** 

- 1 <= k <= nums.length <= 104
- 1 <= nums[i].length <= 100
- nums[i] consists of only digits.
- nums[i] will not have any leading zeros.

## Solution

**Language:** Java  
**Runtime:** 22 ms (beats 58.55%)  
**Memory:** 54 MB (beats 25.11%)  
**Submitted:** 2026-10-22T15:45:48.713Z  

```java
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // max heap with two conditions.
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (a,b) -> a.length() != b.length()
            ? Integer.compare(b.length(), a.length())
            : b.compareTo(a)
        );
        for(int i = 0; i < nums.length; i++){
                maxHeap.add(nums[i]);
        }
        while(k != 1){
            k--;
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/)