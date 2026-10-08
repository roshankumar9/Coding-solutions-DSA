class Solution {
    public int maxProfit(int n, int[][] edges, int[] score) {
        // Arrays.sort(score);
        int[] degree = new int[n]; // initialize with 0.
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.get(src).add(dst);
            degree[dst]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 0)
                q.add(i);
        }
        int idx = 0;
        int sum = 0;
        while(!q.isEmpty()){
            int maxNode = q.poll();
            int size = q.size();
            while(size != 0){
                size--;
                int node = q.poll();
                if(maxNode < node){
                    q.add(maxNode);
                    maxNode = node;
                } else {
                    q.add(node);
                }
            }
            int val = score[idx++];
            int product = (maxNode + 1) * val;
            sum += product;
            for(int i = 0; i < graph.get(maxNode).size(); i++){
                int next = graph.get(maxNode).get(i);
                degree[next]--;
                if(degree[next] == 0)
                    q.add(next);
            }
        }
        return sum;
    }
}