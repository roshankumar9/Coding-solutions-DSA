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