package trie.trie;

public class Trie {

    /*
     *  we need to implement trie.trie methods that help us insert and search with words
     * */
    private final TrieNode root = new trie.trie.TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.containInTrie(c)) {
                current.put(c);
            }
            current.increase(c);
            current = current.get(c);
        }
        current.isWordEnd = true;
    }

    public int search(String word) {
        trie.trie.TrieNode node = root;
        int counter = 0;
        for (char c : word.toCharArray()) {
            counter += node.retrieveCounter(c);
            System.out.println(c + " it counter equals " + node.retrieveCounter(c));
            node = node.get(c);
        }
        return counter;
    }


    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word);
        }
        int n = words.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = search(words[i]);
        }
        return result;
    }
}



