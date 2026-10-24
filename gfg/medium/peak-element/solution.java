class Solution {
    public int peakElement(int[] arr) {
        // code here
        int n = arr.length - 1;
        int res = -1;
        int neg = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                res = i;
                break;
            }
        }
        if(res == -1 && arr.length == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n] > arr[n - 1]) return n;
        return res;
    }
}