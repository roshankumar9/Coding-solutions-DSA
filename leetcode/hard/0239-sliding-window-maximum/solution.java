class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int low = 0;
        int high = k - 1;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i <= high; i++){
            maxHeap.add(nums[i]);
        }
        res.add(maxHeap.peek());
        high++;
        while(high < nums.length){
            maxHeap.add(nums[high]);
            int max = maxHeap.peek();
            res.add(max);
            if(max <= nums[low]){
                maxHeap.poll();
            }
            low++;
            high++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}