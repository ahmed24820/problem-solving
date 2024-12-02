package Hashing;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.AbstractMap.SimpleEntry;

public class AllOne {

    private HashMap<String , Integer> map;

     private TreeSet <SimpleEntry<Integer,String>> treeSet;

    public AllOne(){
        map = new HashMap<>();
        // this balanced tree (red-black tree) comparator keys with each other if keys are equal we compare values
        // if not we will key diff that if they diff positive that means it comes last else comes first
        treeSet = new TreeSet<>((a,b) -> a.getKey() == b.getKey() ? a.getValue().compareTo(b.getValue()) : a.getKey() - b.getKey());
       }
    public void inc(String key){
     int count = map.getOrDefault(key,0);
     map.put(key , count + 1);
     treeSet.remove(new SimpleEntry<>(count,key));
     treeSet.add(new SimpleEntry<>(count + 1 , key));
    }

    public void dec(String key){
     int count = map.get(key);
     treeSet.remove(new SimpleEntry<>(count,key));
     if (count == 1) map.remove(key);
      else {
          map.put(key,count-1);
          treeSet.add(new SimpleEntry<>(count-1,key));
     }
    }
    public String getMaxKey(){
        return treeSet.isEmpty() ? "" : treeSet.last().getValue();
    }
    public String getMinKey(){
      return treeSet.isEmpty() ? "" : treeSet.first().getValue();
    }

}
