import java.util.*;

public class Reconstruct_Itinerary {
    Map<String, boolean[]> v = new HashMap<>();
    Map<String, List<String>> g = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        for(String[] l : tickets){
            if(!g.containsKey(l[0])) g.put(l[0],new ArrayList<String>());
            g.get(l[0]).add(l[1]);
        }
        for(String st : g.keySet()){
            Collections.sort(g.get(st));
            v.put(st,new boolean[g.get(st).size()]);
        }
        int n = tickets.length + 1;
        List<String> res= new LinkedList<>();
        backtracking("JFK", n , res);
        return res;
    }

    boolean backtracking(String start, int n, List<String> res){
        res.add(start);
        if(res.size() == n){
            return true;
        }
        List<String> l = g.get(start);
        if(l == null){
            res.remove(res.size()-1);
            return false;
        }
        for(int pos = 0; pos < l.size(); pos++){
            if(v.get(start)[pos]) continue;
            v.get(start)[pos] = true;
            if(backtracking(l.get(pos),n,res)) return true;
            v.get(start)[pos] =false;
        }
        res.remove(res.size() - 1);
        return false;
    }
}
