class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // max heap with two conditions.
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (a,b) -> a.length() != b.length()
            ? Integer.compare(b.length(), a.length())
            : b.compareTo(a)
        );
        for(int i = 0; i < nums.length; i++){
                maxHeap.add(nums[i]);
        }
        while(k != 1){
            k--;
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}