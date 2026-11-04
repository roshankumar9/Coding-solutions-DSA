class Solution {
    public int setBitCount(int n){
        int res = 0;
        while(n > 0){
            res++;
            n = n & (n - 1);
        }
        return res;
    }
    public int[] countBits(int n) {
        int res[] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int val = setBitCount(i);
            res[i] = val;
        }
        return res;
    }
}