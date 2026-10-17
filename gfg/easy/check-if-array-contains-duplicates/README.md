# Check if array contains duplicates

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array  **arr[]**, check if the array contains any  **duplicate**  value.

 **Examples:** 

```
Input: arr = [4, 5, 6, 4]
Output: true
Explaination: 4 is the duplicate value.
```

```
Input: arr = [1, 2, 3, 4]
Output: false
Explaination: All values are distinct.
```

 **Constraint:** 
1<=arr.size()<=105
0<=arr[i]<=104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T05:30:35.711Z  

```java
class Solution {
    public boolean checkDuplicates(int arr[]) {
        // Code here
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])) return true;
            set.add(arr[i]);
        }
        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-if-array-contains-duplicates/1)