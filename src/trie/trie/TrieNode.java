package trie.trie;

public class TrieNode {

    TrieNode[] trieNodes ;
    boolean isWordEnd;
    int counter;

    public TrieNode(){
        trieNodes = new TrieNode[26];
        isWordEnd = false;
        counter = 0 ;
    }

    public boolean containInTrie(char c){
        return trieNodes[ c - 'a'] != null;
     }

     public TrieNode get(char c){
        return trieNodes[c-'a'];
     }

     public void put(char c){
        trieNodes[c - 'a'] = new TrieNode();
     }

     public void increase(char c){
        trieNodes[c-'a'].counter++;
     }
     public int retrieveCounter(char c){
        return trieNodes[c-'a'].counter;
     }



}
