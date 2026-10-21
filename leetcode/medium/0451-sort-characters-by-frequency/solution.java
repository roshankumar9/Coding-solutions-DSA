class Pair{
    int first;
    char second;
    Pair(int first, char second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public String frequencySort(String s) {
        // min heap.
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> a.first != b.first ? b.first - a.first : Character.compare(a.second, b.second)
        );
        // frequency count.
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            int frq = e.getValue();
            char c = e.getKey();
            Pair pair = new Pair(frq, c);
            minHeap.add(pair);
        }
        StringBuilder res = new StringBuilder();
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int times = p.first;
            char c = p.second;
            for(int i = 0; i < times; i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}