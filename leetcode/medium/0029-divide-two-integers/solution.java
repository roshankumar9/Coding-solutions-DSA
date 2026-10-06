class Solution {
    public int divide(int dividend, int divisor) {
        int res = dividend / divisor;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        } else if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE; 
        } else if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else {
            return res;
        }
    }
}