class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        int degree[] = new int[V];
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.get(src).add(dst);
            degree[dst]++;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(degree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i = 0; i < graph.get(node).size(); i++){
                int next = graph.get(node).get(i);
                degree[next]--;
                if(degree[next] == 0)
                    q.add(next);
            }
        }
        
        return res;
    }
}