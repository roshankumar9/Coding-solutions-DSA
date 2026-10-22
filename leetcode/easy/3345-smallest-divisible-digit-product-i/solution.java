class Solution {
    public int product(int n){
        int res = 1;
        while(n != 0){
            int rem = n % 10;
            res *= rem;
            n = n / 10;
        }
        return res;
    }
    public int smallestNumber(int n, int t) {
        int ans = 0;
        while(true){
            int val = product(n);
            if(val % t == 0){
                ans = n;
                break;
            }
            n++;
        }
        return ans;
    }
}