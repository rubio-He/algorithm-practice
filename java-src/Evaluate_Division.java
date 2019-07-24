import java.util.*;
public class Evaluate_Division {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> edge = new HashMap<>();
        Map<String, ArrayList<Double>> vals = new HashMap<>();

        for(int i = 0; i < equations.length; i++){
            double val = values[i];
            String[] e = equations[i];
            String from = e[0];
            String to = e[1];
            if(!edge.containsKey(from)) edge.put(from, new ArrayList<>());
            if(!edge.containsKey(to)) edge.put(to, new ArrayList<>());
            if(!vals.containsKey(from)) vals.put(from, new ArrayList<>());
            if(!vals.containsKey(to)) vals.put(to, new ArrayList<>());
            edge.get(from).add(to);
            edge.get(to).add(from);
            vals.get(from).add(val);
            vals.get(to).add(1/val);
        }

        double[] res = new double[queries.length];

        for(int i =0; i < res.length; i++){
            String[] q = queries[i];
            double v = dfs(q[0], q[1], vals, edge, new HashSet<>(), 1.0);
            res[i] = v == 0.0 ? -1.0 : v;
        }
        return res;


    }

    public double dfs(String start, String end, Map<String, ArrayList<Double>> vals, Map<String, ArrayList<String>> edge, HashSet<String> set, double val){
        if(start.equals(end)) return val;
        if(set.contains(start)) return 0.0;
        if(!edge.containsKey(start)) return 0.0;
        for(int i = 0; i < edge.get(start).size(); i++){
            String to = edge.get(start).get(i);
            set.add(to);
            double v = vals.get(start).get(i);
            double temp = dfs(to, end, vals,edge, set,val * v);
            if(temp != 0.0) return temp;
            set.remove(to);
        }
        return 0.0;
    }
}
