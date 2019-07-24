import java.util.*;

public class Insert_Delete_GetRandom_O1_Duplicates_allowed {
    Random rand;
    HashMap<Integer, Integer> m1;
    HashMap<Integer, HashSet<Integer>> m2;
    /** Initialize your data structure here. */
    public Insert_Delete_GetRandom_O1_Duplicates_allowed() {
        m1 = new HashMap<>();
        m2 = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int size1 = m1.size();
        m1.put(size1+1,val);
        if(!m2.containsKey(val)){
            HashSet<Integer> s = new HashSet<>();
            s.add(size1+1);
            m2.put(val,s);
            return true;
        }
        else{
            m2.get(val).add(size1+1);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(m2.containsKey(val)){
            Set<Integer> set = m2.get(val);
            int toRemove = set.iterator().next();

            set.remove(toRemove);

            if(set.size() == 0){
                m2.remove(val);
            }

            if(toRemove == m1.size()){
                m1.remove(toRemove);
                return true;
            }

            int size1 = m1.size();
            int key = m1.get(size1);

            HashSet<Integer> setChange = m2.get(key);
            setChange.remove(size1);
            setChange.add(toRemove);

            m1.remove(size1);
            m1.put(toRemove,key);

            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {

        if(m1.size() == 0) return -1;
        return m1.get(rand.nextInt(m1.size())+1);
    }
}


