class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(first < nums[i]){
                third = second;
                second = first;
                first = nums[i];
            } else if(second <= nums[i] && nums[i] != first){
                third = second;
                second = nums[i];
            } else {
                third = nums[i];
            }
        }
        return third == Integer.MIN_VALUE ? first : third;
    }
}