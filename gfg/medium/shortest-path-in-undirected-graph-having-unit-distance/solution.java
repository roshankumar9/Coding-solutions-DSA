class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        // int queue we will store current node and path required path weight.
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int srcc = edges[i][0];
            int dst = edges[i][1];
            graph.get(srcc).add(dst);
            graph.get(dst).add(srcc);
        }
        
        q.add(new int[]{src, 0}); // we don't need any path to go src to src, so 0.
        while(!q.isEmpty()){
            
            int data[] = q.poll();
            int node = data[0];
            int path = data[1];
            
            if(visited[node] && node == dest) return path;
            for(int i = 0; i < graph.get(node).size(); i++){
                int next = graph.get(node).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, path + 1});
                }
            }
        }
        return -1;
    }
}