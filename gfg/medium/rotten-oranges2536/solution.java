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