# Shortest Path in Unweighted Graph

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an undirected graph with  **V**  vertices numbered from 0 to V-1 and  **E**  edges, where **edges[i] = [u, v]**  denotes an undirected edge between vertex u and vertex v, given two vertices  **src**  and  **dest**, find the length of the shortest path from src to dest. If there is no path between src and dest, return -1.

 **Note:** All edges have a unit weight of 1.

 **Examples :** 

```
Input: V = 9, edges[][] = [[0, 1], [0, 3], [1, 2], [3, 4], [4, 5], [2, 6], [5, 6], [6, 7], [6, 8], [7, 8]], src = 0, dest = 8
Output: 4
Explanation: One of the shortest paths from vertex 0 to vertex 8 is 0 -> 1 -> 2 -> 6 -> 8, which contains 4 edges.

```

```
Input: V = 4, edges[][]= [[0, 3], [1, 3]], src = 3, dest = 2
Output: -1
Explanation: There is no path between vertices 3 and 2.

```

 **Constraints:** 

1 ≤ V ≤ 10^4
0 ≤ E ≤ V × (V - 1) / 2
0 ≤ edges[i][0], edges[i][1] < V

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-10T16:00:52.740Z  

```java
class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        // int queue we will store current node and path required path weight.
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int srcc = edges[i][0];
            int dst = edges[i][1];
            graph.get(srcc).add(dst);
            graph.get(dst).add(srcc);
        }
        
        q.add(new int[]{src, 0}); // we don't need any path to go src to src, so 0.
        while(!q.isEmpty()){
            
            int data[] = q.poll();
            int node = data[0];
            int path = data[1];
            
            if(visited[node] && node == dest) return path;
            for(int i = 0; i < graph.get(node).size(); i++){
                int next = graph.get(node).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, path + 1});
                }
            }
        }
        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1)