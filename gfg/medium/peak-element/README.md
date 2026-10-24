# Peak in Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist).

If there are multiple peak elements, Return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

 **Note:**  Consider the element before the first element and the element after the last element to be negative infinity.

**Examples :
**

```
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
```

```
Input: arr = [10, 20, 15, 2, 23, 90, 80]
Output: true
Explanation: Element 20 at index 1 is a peak since 10 < 20 > 15. Index 5 (value 90) is also a peak, but returning any one peak index is valid.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-24T18:16:32.661Z  

```java
class Solution {
    public int peakElement(int[] arr) {
        // code here
        int n = arr.length - 1;
        int res = -1;
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                res = i;
                break;
            }
        }
        if(res == -1 && arr.length == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n] > arr[n - 1]) return n;
        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/peak-element/1)