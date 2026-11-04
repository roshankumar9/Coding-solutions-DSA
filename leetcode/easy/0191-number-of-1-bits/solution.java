class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n > 0){
            res++;
            n = n & (n - 1); // here we can remove right most one set bit at once, it means we can count set bit also.
        }
        return res;
    }
}