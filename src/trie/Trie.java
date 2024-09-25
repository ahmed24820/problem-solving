package trie;

public class Trie {

    /*
   *  we need to implement trie methods that help us insert and search with words
   * */
    private TrieNode root;

    public void insert(String word) throws IllegalAccessException {

       if (word.isEmpty() || word == null){
          throw new IllegalAccessException("invalid input");
       }
        TrieNode current = root;
       for (char c : word.toCharArray()){
           if (!current.containInTrie(c)){
              current.put(c);
           }
             current.increase(c);
           current = current.get(c);
           }
         current.isWordEnd = true;
       }

       public int search(String word){
        TrieNode node = root;
        int counter = 0;
        for (char c : word.toCharArray()){
           counter += node.retrieveCounter(c);
           node = node.get(c);
        }
        return counter;
       }

   public int[] sumPrefixScores(String[] words) throws IllegalAccessException {
        for (String word : words){
          insert(word);
        }
        int n = words.length;
        int [] result = new int[n];
        for (int i = 0 ; i < n ; i++){
           result[i] = search(words[i]);
        }
       return result;
    }
}



