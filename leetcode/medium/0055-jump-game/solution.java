class Solution {
    HashMap<Integer, Boolean> dp = new HashMap<>();
    public boolean fun(int arr[], int n, int idx){
        if(idx >= n){
            return true;
        }
        if(dp.containsKey(idx)) return dp.get(idx);
        dp.put(idx, false);
        boolean res = fun(arr, n, idx + arr[idx]);
        return res;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        return fun(nums, n - 1, 0);
    }
}