# Top K Frequent in Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a non-empty integer array  **arr[].**  Your task is to find and return the top  **k**  elements which have the highest frequency in the array.

 **Note:** If two numbers have the same frequency, the larger number should be given the higher priority.

 **Examples:** 

```
Input: arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2
Output: [4, 1]
Explanation: Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum frequency and 4 is larger than 1.
```

```
Input: arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
Output: [5, 11, 7, 10]
Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is 2, frequency of 10 is 1.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ k ≤ no. of distinct elements

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T14:54:33.872Z  

```java
class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        // min-heap wiht both comparision.
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.first != b.first ? a.first - b.first : a.second - b.second);
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int frq = e.getValue();
            int val = e.getKey();
            Pair pair = new Pair(frq, val);
            
            minHeap.add(pair);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll().second);
        }
        Collections.reverse(res);
        return res;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1)