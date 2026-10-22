class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int one = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                res = Math.max(res, one);
                one = 0;
            } else {
                one++;
            }
        }
        res = Math.max(res, one); // if max ones present in last of the array.
        return res;
    }
}