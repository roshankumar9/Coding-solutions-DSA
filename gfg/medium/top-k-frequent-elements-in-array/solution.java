class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        // min-heap wiht both comparision.
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.first != b.first ? a.first - b.first : a.second - b.second);
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int frq = e.getValue();
            int val = e.getKey();
            Pair pair = new Pair(frq, val);
            
            minHeap.add(pair);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(0, minHeap.poll().second);
        }
        return res;
    }
}
