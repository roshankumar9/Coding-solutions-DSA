class Solution {
    public int fun(int[] arr, int n, int i, int free, int[][] dp){
        if(i == n) return 0;
        if(dp[i][free] != -1) return dp[i][free];
        if(free == 0){
            int val = fun(arr, n, i + 1, 1, dp);
            dp[i][free] = val;
            return val;
        }
        
        int ch1 = arr[i] + fun(arr, n, i + 1, 0, dp);
        int ch2 = fun(arr, n, i + 1, 1, dp);
        
        int ans = Math.max(ch1, ch2);
        dp[i][free] = ans;
        
        return ans;
    }
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(arr, n, 0, 1, dp);
    }
}