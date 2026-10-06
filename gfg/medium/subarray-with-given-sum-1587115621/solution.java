
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        
        int low = 0;
        int high = 0;
        int sum = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(high = 0; high < arr.length; high++){
            sum = sum + arr[high];
            while(sum > target){
                sum = sum - arr[low];
                low++;
            }
            if(sum == target && low <= high){
                res.add((low + 1));
                res.add((high + 1));
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}
