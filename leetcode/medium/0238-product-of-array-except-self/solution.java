class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
        int i = 1;
        int j = n - 2;
        while(i != n){
            pre[i] = nums[i - 1] * pre[i - 1];
            i++;
            suf[j] = suf[j + 1] * nums[j + 1];
            j--;
        }
        int x = 0;
        while(x != n){
            int val = pre[x] * suf[x];
            nums[x] = val;
            x++;
        }
        return nums;
    }
}