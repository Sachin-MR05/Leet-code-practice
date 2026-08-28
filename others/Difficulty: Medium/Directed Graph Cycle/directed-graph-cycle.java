class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for(int i =0;i<V;i++) adj.add(new ArrayList<Integer>());
        
        for(int i =0;i<edges.length;i++){
            int a =edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }
        int[] visit = new int[V];
        for(int i : visit) i=-1;
        //int Node =0;
        for(int Node =0;Node<V;Node++){
            if(visit[Node]!=1){
        for(int it: adj.get(Node)){
            if(dfs(adj,it,visit)) return true;
        }}}
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int Node,int[] visit){
        visit[Node] = 1;
        visit[Node] = 2;
        for(int it:adj.get(Node)){
            if(visit[it]==2) return true;
            if(visit[it]!=1){
                if(dfs(adj,it,visit)) return true;
            }
            //else 
        }
        visit[Node]=1;
        return false;
    }
}