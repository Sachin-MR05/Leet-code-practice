class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int n = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0;i<V;i++) adj.add(new ArrayList<Integer>());
        
        for(int i=0;i< n;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
    
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[V];
        
        for(int Node=0;Node<V;Node++){

            if(!visit[Node]){
  
            dfs(Node,visit,adj,stack);}
        }
       ArrayList<Integer> ans = new ArrayList<>();
       while (!stack.isEmpty()) {
          ans.add(stack.pop());
      }
       return ans;
        }
    
    public static void dfs(int Node,boolean visit[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visit[Node] = true;
        
        for(int it : adj.get(Node)){
            if(!visit[it])
                            
            dfs(it,visit,adj,stack);
            }
            stack.add(Node);
        
    }
}