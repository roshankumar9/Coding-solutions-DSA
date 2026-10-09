class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void fun(int[] arr, int n, int idx, List<Integer> temp){
        if(n == idx){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[idx]);
        fun(arr, n, idx + 1, temp);
        temp.remove(temp.size() - 1);

        // removing duplicates here.
        while(idx + 1 < n && arr[idx] == arr[idx + 1]){
            idx++;
        }

        fun(arr, n, idx + 1, temp);

        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        fun(nums, n, 0, temp);
        return res;
    }
}