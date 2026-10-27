class Solution {
    public int fun(int[]nums, int n, int idx, int free, int[][] dp){
        if(idx == n) return 0;
        if(dp[idx][free] != -1) return dp[idx][free];
        if(free == 0){
            int val = fun(nums, n, idx + 1, 1, dp);
            dp[idx][free] = val;
            return val;
        }
        int ch1 = nums[idx] + fun(nums, n, idx + 1, 0, dp);
        int ch2 = fun(nums, n, idx + 1, 1, dp);
        int ans = Math.max(ch1, ch2);
        dp[idx][free] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(nums, n, 0, 1, dp);
     }
}