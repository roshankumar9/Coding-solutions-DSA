class Solution {
    public int fun(int val[], int wt[], int n, int i, int cap, int[][] dp){
        if(i == n) return 0;
        
        if(dp[i][cap] != -1) return dp[i][cap];
        
        if(wt[i] > cap){
            int nex = fun(val, wt, n, i + 1, cap, dp);
            dp[i][cap] = nex;
            return nex;
        }
        
        // choices.
        int yes = val[i] + fun(val, wt, n, i + 1, cap - wt[i], dp);
        int no = fun(val, wt, n, i + 1, cap, dp);
        
        int ans = Math.max(yes, no);
        dp[i][cap] = ans;
        
        return ans;
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= W; j++){
                dp[i][j] = -1;
            }
        }
        return fun(val, wt, n, 0, W, dp);
    }
}
