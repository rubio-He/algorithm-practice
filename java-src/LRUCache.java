

import java.util.*;
public class LRUCache {
    class DBLnode{
        int val;
        int key;
        DBLnode next;
        DBLnode pre;
        public DBLnode(int v,int k){
            this.val = v;
            this.key = k;
        }
        public DBLnode(){
            this.val = 0;
            this.key = 0;
        }
    }

    private void delnode(DBLnode node){
        DBLnode p = node.pre;
        DBLnode n = node.next;
        p.next = n;
        n.pre = p;
    }

    private void addnode(DBLnode node){
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }


    HashMap<Integer, DBLnode> hm;
    int len;
    int count;
    DBLnode head = new DBLnode();
    DBLnode tail = new DBLnode();

    public LRUCache(int capacity) {
        hm = new HashMap<Integer,DBLnode>();
        int len = capacity;
        head.next = tail;
        tail.pre = head;
        head.pre = null;

        count = 0;
    }

    public int get(int key) {

        if(!hm.containsKey(key)) return -1;
        DBLnode node = hm.get(key);
        delnode(node);
        addnode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(get(key) != -1){
            hm.get(key).val = value;
            return;
        }
        if(hm.size() == len){
            hm.remove(head.next.key);
            delnode(head.next);
        }
        DBLnode insert = new DBLnode(value,key);
        hm.put(key, insert);
        addnode(insert);
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */