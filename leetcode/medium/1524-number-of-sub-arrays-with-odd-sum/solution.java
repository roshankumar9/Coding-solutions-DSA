class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int res = 0;
        int sum = 0;
        int oddSum = 0;
        int evenSum = 1; //empty subarray is even, so evenSum count is 1 initially.
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum % 2 == 0){
                evenSum++;
                res = (res + oddSum) % MOD;
            } else {
                oddSum++;
                res = (res + evenSum) % MOD;
            }
        }
        return res;
    }
}