import java.util.*;
class LRUsingle {
    Map<Integer, node> pos;
    node head;
    node tail;
    int cap;
    int size;
    public LRUsingle(int capacity) {
        pos = new HashMap<>();
        head = new node(0,0);
        tail = head;
        cap = capacity;
        size = 0;
    }


    void moveToTail(node pre){
        if(pre.next == tail) return;
        node n = pre.next;
        pre.next = n.next;
        if(n.next != null)  pos.put(n.next.key,pre);
        tail.next = n;
        n.next = null;
        pos.put(n.key, tail);
        tail = n;


    }

    public int get(int key) {
        if(!pos.containsKey(key)) return -1;
        moveToTail(pos.get(key));
        return pos.get(key).next.value;
    }

    public void put(int key, int value) {
        if(pos.containsKey(key)){
            pos.get(key).next.value = value;
            moveToTail(pos.get(key));
        }
        else{
            node newNode = new node(key,value);
            tail.next = newNode;
            pos.put(key,tail);
            tail = newNode;
            size++;
            if(size > cap){
                pos.remove(head.next.key);
                head.next = head.next.next;
                if(head.next != null){
                    pos.put(head.next.key, head);
                }
                size--;
            }

        }
    }
}

class node{
    node next;
    int key;
    int value;
    public node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */