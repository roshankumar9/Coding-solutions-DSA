class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int sum = arr[low] + arr[high];
            if(sum == target) return true;
            else if(sum < target) low++;
            else high--;
        }
        return false;
    }
}