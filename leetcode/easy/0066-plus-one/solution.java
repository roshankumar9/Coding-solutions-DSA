class Solution {
    public int[] plusOne(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length - 1;
        int carray = 0; 
        int one = 1;
        for(int i = n; i >= 0; i--){
            if(i < n) one = 0;
            int sum = one + carray + nums[i];
            carray = sum / 10;
            sum = sum % 10;
            list.add(0, sum);
        }
        if(carray != 0) list.add(0, carray);
        return list.stream().mapToInt(i -> i).toArray();
    }
}