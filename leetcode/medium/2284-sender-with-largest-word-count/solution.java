class Pair{
    int count;
    String name;
    Pair(int count, String name){
        this.count = count;
        this.name = name;
    }
}
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = senders.length;
        for(int i = 0; i < n; i++){
            String sender = senders[i];
            int msgCount = messages[i].split("\\s+").length;
            map.put(sender, map.getOrDefault(sender, 0) + msgCount);
        }
        
        // max heap.
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) ->
            a.count != b.count ? b.count - a.count : b.name.compareTo(a.name)
        );

        for(Map.Entry<String, Integer> e : map.entrySet()){
            String sender = e.getKey();
            int msgCount = e.getValue();
            Pair pair = new Pair(msgCount, sender);
            if(maxHeap.isEmpty() || maxHeap.peek().count == msgCount){
                maxHeap.add(pair);
                continue;
            }
            if(maxHeap.peek().count < msgCount){
                maxHeap.poll();
                maxHeap.add(pair);
            }
        }
        return maxHeap.peek().name;
    }
}