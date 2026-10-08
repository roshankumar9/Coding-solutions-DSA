# Topological Sort

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a Directed Acyclic Graph (DAG) with  **V** vertices numbered from 0 to V - 1 and  **E** directed edges represented by a 2D array  **edges[][]**, where edges[i] = [u, v] denotes a directed edge from vertex u to vertex v, return a topological ordering of all the vertices.

A topological ordering is a linear ordering of the vertices such that for every directed edge u -> v, vertex u appears before vertex v in the ordering.

 **Note:** As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

 **Examples:** 

```
Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
```

```
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
```

 **Constraints:** 
2  ≤  V  ≤  5 x 103
1  ≤  E = edges.size()  ≤  min[105, (V * (V - 1)) / 2]
0 ≤ edges[i][0], edges[i][1] < V

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-08T14:48:38.511Z  

```java
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        int degree[] = new int[V];
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.get(src).add(dst);
            degree[dst]++;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(degree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i = 0; i < graph.get(node).size(); i++){
                int next = graph.get(node).get(i);
                degree[next]--;
                if(degree[next] == 0)
                    q.add(next);
            }
        }
        
        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/topological-sort/1)