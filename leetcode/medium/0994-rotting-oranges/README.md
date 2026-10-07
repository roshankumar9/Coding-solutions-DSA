# Rotting Oranges

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` `grid` where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.

Every minute, any fresh orange that is  **4-directionally adjacent**  to a rotten orange becomes rotten.

Return  *the minimum number of minutes that must elapse until no cell has a fresh orange*. If  *this is impossible, return*  `-1`.

 

 **Example 1:** 

```
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

```

 **Example 2:** 

```
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

```

 **Example 3:** 

```
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 10
- grid[i][j] is 0, 1, or 2.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 86.74%)  
**Memory:** 44.3 MB (beats 24.11%)  
**Submitted:** 2026-10-07T03:37:28.061Z  

```java
class Solution {
    // index validation function.
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    // direction arrays.
    int x[] = {-1, 1, 0, 0};
    int y[] = {0, 0, -1, 1};

    // main bfs
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // pushing all rotten into the queue, because all rotten oranges will work together.
        // freash count also for checking reaming freash oranges.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    grid[i][j] = -2;
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int res = 0;
        while(!q.isEmpty() && fresh > 0){
            res++;
            int size = q.size();
            while(size != 0){
                size--;
                int pair[] = q.poll();
                int r = pair[0];
                int c = pair[1];
                for(int i = 0; i < 4; i++){
                    int row = r + x[i];
                    int col = c + y[i];
                    if(isValid(row, col, n, m) && grid[row][col] == 1){
                        q.add(new int[]{row, col});
                        grid[row][col] = -2;
                        fresh--;
                    }
                }
            }
        }
        // agar koi fresh bacha huaa hai.
        if(fresh > 0) return -1;
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotting-oranges/)