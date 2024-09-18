package LinkedList;

import java.util.HashMap;

public class LRUCache {
    Node right = null, left = null;
     int capacity = 0, count =0;
     HashMap <Integer ,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
     this.capacity = capacity;
      right =new Node(0) ; left = new Node(0);
      right.next = null; left.next = right;
       right.prev = left ; left.prev = null;
       map.put(right.data, right);
       map.put(left.data, left);
    }
    public void addNode(Node dummy){
      dummy.next = left.next;
      dummy.next.prev = dummy;
      dummy.prev = left;
    }
    public void removeNode(Node node){
     node.prev.next = node.next;
     node.next.prev = node.prev;
    }


    public int get(int key) {
      if(map.containsKey(key)){
        Node node = map.get(key);
        int value = node.data;
        removeNode(node);
        addNode(node);
        return value;
      }
      return -1 ;
    }
    public void put(int key, int value) {

     }
}


