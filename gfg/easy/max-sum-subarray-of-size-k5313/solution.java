class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int res = 0;
        int low = 0;
        int high = k - 1;
        int sum = 0;
        for(int i = 0; i <= high; i++){
            sum += arr[i];
            res = sum;
        }
        while(high != arr.length){
            high++;
            if(high == arr.length) break;
            sum += arr[high];
            sum -= arr[low];
            low++;
            res = Math.max(res, sum);
        }
        return res;
    }
}