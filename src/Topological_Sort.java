/**
 * Created by Hobbes on 6/5/17.
 */
import java.util.*;
public class Topological_Sort {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // adjacent List
    //Constructor
    Topological_Sort(int v){
        this.V = v;
        this.adj = new LinkedList[v];
        for( int i = 0; i < v ; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    void addEdge(int v, int w ){
        adj[v].add(w);
    }

    void topologicalSortUntil(int v, boolean visited[], Stack<Integer> stack){
        visited[v] = true;
        Integer i;

        //Recur for all the vertices adjacent to this
        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()){
            i = it.next();
            if(!visited[i])
                topologicalSortUntil(i,visited, stack);
        }
        stack.push(new Integer(v));
    }

    void sort(){
        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[V];
        for (int i = 0 ; i < V; i++){
            visited[i] =false;
        }

        for(int i = 0; i < V; i++)
            if(visited[i] == false){
                topologicalSortUntil(i, visited, stack);
            }
        while(stack.empty() == false)
            System.out.print(stack.pop() + " ");

    }
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Topological_Sort g = new Topological_Sort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.sort();
    }
}
