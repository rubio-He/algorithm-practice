import java.util.*;
public class printCycle {
    public static void printCyc(int nodes, int[][] edges){
        LinkedList[] adj = new LinkedList[nodes];
        for(int i = 0; i < nodes; i++) {
            adj[i] = new LinkedList();
        }
        for(int[] edge : edges) {
            adj[edge[1]].add(edge[0]);
        }
        int v[] = new int[nodes];
        for(int i = 0; i < nodes; i++){
            List<Integer> res = dfs(adj, v , i, new LinkedList<>());
            if(res != null) {
                System.out.println(res);
                return;
            }
        }
    }

    public static List<Integer> dfs(LinkedList[] adj, int[] v, int i, List<Integer> res){
        v[i] = 1;
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()){
            int j = it.next();
            if(v[j] == 1) {
                res.add(j);
                return res;
            }
            if(v[j] == 0) {
                v[j] = 1;
                List<Integer> temp = dfs(adj,v,j,res);
                if(temp != null){
                    temp.add(j);
                    return temp;
                }
            }
        }
        v[i] = 2;
        return null;
    }

    public static void main(String[] args){
        printCyc(6, new int[][]{{0,1},{1,2},{2,3},{3,5},{5,4},{4,3}});
    }
}
