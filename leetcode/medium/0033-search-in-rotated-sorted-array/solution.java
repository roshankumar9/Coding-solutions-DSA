class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while(l <= h){
            int gess = l + (h - l) / 2;
            // gess part 2 me ho tab.
            if(nums[gess] > nums[n - 1]){
                if(nums[gess] == target){
                    return gess;
                } else if(target > nums[gess]) {
                    l = gess + 1;
                } else {
                    if(target < nums[0])
                        l = gess + 1;
                    else
                        h = gess - 1;
                }
            }
            // gess part 1 me ho tab.
            else {
                if(nums[gess] == target){
                    return gess;
                } else if(target < nums[gess]){
                    h = gess - 1;
                } else {
                    if(target > nums[n - 1])
                        h = gess - 1;
                    else 
                        l = gess + 1;
                }
            }
        }
        return -1;
    }
}