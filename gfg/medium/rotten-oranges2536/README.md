# Rotten Oranges

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a matrix  **mat[][]**, where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 **0** : Empty cell
 **1**  : Cell have fresh oranges
 **2**  : Cell have rotten oranges

Determine the minimum time required so that all the oranges become rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

 **Note**  **:**  If it is impossible to rot every orange then simply return -1.

 **Examples:** 

```
Input: mat[][] = [[2, 1, 0, 2, 1], [1, 0, 1, 2, 1], [1, 0, 0, 2, 1]]
Output: 2
Explanation: 

Oranges at positions (0,0), (0,3), (1,3), and (2,3) will rot adjacent fresh oranges in successive time frames.
All fresh oranges become rotten after 2 units of time.
```

```
Input: mat[][] = [[2, 1, 0, 2, 1], [0, 0, 1, 2, 1], [1, 0, 0, 2, 1]]
Output: -1
Explanation: Oranges at positions (0,0), (0,3), (1,3), and (2,3) rot some fresh oranges,
but the fresh orange at (2,0) can never be reached, so not all oranges can rot.

```

 **Constraints:** 
1 ≤ mat.size() ≤ 500
1 ≤ mat[0].size() ≤ 500
mat[i][j] = {0, 1, 2}

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-07T03:19:43.687Z  

```java
class Solution {
    // index validatoin funtion.
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    
    // direction array.
    int x[] = {-1, 1, 0, 0};
    int y[] = {0, 0, -1, 1};
    
    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int freashOrangeCount = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2){
                    int[] pair = {i, j};
                    q.add(pair);
                    mat[i][j] = -2;
                } else if(mat[i][j] == 1){
                    freashOrangeCount++;
                }
            }
        }
        
        // bfs
        int times = 0;
        while(!q.isEmpty() && freashOrangeCount > 0){
            int size = q.size();
            times++;
            while(size != 0){
                size--;
                int index[] = q.poll();
                int r = index[0];
                int c = index[1];
                // direction.
                for(int i = 0; i < 4; i++){
                    int row = r + x[i];
                    int col = c + y[i];
                    if(isValid(row, col, n, m) && mat[row][col] == 1){
                        int pair[] = {row, col};
                        q.add(pair);
                        mat[row][col] = -2;
                        freashOrangeCount--;
                    }
                }
            }
        }
        if(freashOrangeCount > 0) return -1;
        return times;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1)