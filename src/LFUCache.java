
import java.util.*;
public class LFUCache {
    Map<Integer,Integer> values = new HashMap<>();
    Map<Integer,Integer> counts = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();
    int cap;
    int min;

    public LFUCache(int capacity) {
        cap = capacity;
        min = -1;
        lists.put(1,new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if(!values.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key,count+1);
        counts.remove(key);
        if(count == min && lists.get(min).size() == 0) min++;
        if(!lists.containsKey(count+1)) lists.put(count+1, new LinkedHashSet<Integer>());
        lists.get(count+1).add(key);
        return values.get(key);


    }

    public void put(int key, int value) {
        if(cap <= 0) return;
        if(values.containsKey(key)){
            values.put(key,value);
            get(key);
            return;
        }
        if(values.size() >= cap){
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            values.remove(evict);
        }
        values.put(key,value);
        counts.put(key,1);
        lists.get(1).add(key);
        min = 1;
    }
}
