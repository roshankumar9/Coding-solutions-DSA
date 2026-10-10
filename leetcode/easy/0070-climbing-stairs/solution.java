class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int fun(int n, int idx){
        if(idx >= n){
            if(n == idx) return 1;
            return 0;
        }
        if(dp.containsKey(idx)) return dp.get(idx);
        int ch1 = fun(n, idx + 1);
        int ch2 = fun(n, idx + 2);
        int ans = ch1 + ch2;
        dp.put(idx, ans);
        return ans;
    }
    public int climbStairs(int n) {
        return fun(n, 0);
    }
}