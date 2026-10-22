class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            maxHeap.add(nums[i]);
        }
        while(k != 1){
            k--;
            maxHeap.poll();
        }
        return maxHeap.peek();
        
        // for(int i = 0; i < k; i++){
        //     minHeap.add(nums[i]);
        // }

        // for(int i = k; i < nums.length; i++){
        //     if(minHeap.peek() <= nums[i]){
        //         minHeap.poll();
        //         minHeap.add(nums[i]);
        //     }
        // }
        // return minHeap.peek();
    }
}