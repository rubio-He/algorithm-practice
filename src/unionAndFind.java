/**
 * Created by Hobbes on 6/21/17.
 */

import java.util.*;
public class unionAndFind {
    private Map<Integer, Integer> uf;
    private Map<Integer, Integer> size;
    public int count = 0;
    public unionAndFind(){
        this.uf = new HashMap<>();
        this.size = new HashMap<>();

    }

    public void add(int number){
        uf.put(number,number);
        size.put(number,1);
        count++;

    }

    public int find(int index){
        while(index != uf.get(index)){
            uf.put(uf.get(index) , uf.get(uf.get(index)));
            index = uf.get(index);
        }
        return index;
    }


    public boolean unite(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i==j) return false;
        if (size.get(i) > size.get(j)) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        uf.put(i,j);
        size.put(j, size.get(j) + size.get(i));
        count--;
        return true;
    }
}
