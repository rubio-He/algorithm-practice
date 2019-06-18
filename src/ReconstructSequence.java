import java.util.*;
public class ReconstructSequence {
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();

        for(List<Integer> seq : seqs){
            if(seq.size() == 1) {
                if (!map.containsKey(seq.get(0))) {
                    in.put(seq.get(0), 0);
                    map.put(seq.get(0), new HashSet<>());
                }

            }
            else{
                for(int i = 0; i < seq.size() - 1; i++){
                    if(!map.containsKey(seq.get(i))){
                        map.put(seq.get(i), new HashSet<>());
                        in.put(seq.get(i), 0);
                    }
                    if(!map.containsKey(seq.get(i+1))){
                        map.put(seq.get(i+1), new HashSet<>());
                        in.put(seq.get(i+1), 0);
                    }
                    if(map.get(seq.get(i)).add(seq.get(i+1))){
                        in.put(seq.get(i+1), in.get(seq.get(i+1))+1);
                    }
                }
            }

        }


        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : in.entrySet()){
            if(entry.getValue() == 0) q.add(entry.getKey());
        }
        int index = 0;
        while(!q.isEmpty()){
            if(q.size() > 1) return false;
            int from = q.poll();
            if( index == org.length || from != org[index++]) return false;
            for(int to : map.get(from)){
                in.put(to, in.get(to)-1);
                if(in.get(to) == 0) q.add(to);
            }
        }

        return index == org.length;

    }


    public static void main(String[] args){
        List<List<Integer>> seqs = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);l1.add(2);
        List<Integer> l2 = new LinkedList<>();
        l2.add(1);l2.add(3);
        List<Integer> l3 = new LinkedList<>();
        l3.add(2);l3.add(3);

        seqs.add(l1); seqs.add(l2);seqs.add(l3);


        sequenceReconstruction(new int[]{1,2,3},seqs);
    }
}
