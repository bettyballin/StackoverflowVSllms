import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    // Assume the input is a list of words (ArrayList<String>)
    public void build(List<String> words) {
        for (String word : words) {
            TrieNode current = this.root;
            char[] characters = word.toCharArray();
            current = insert(current, characters);
        }
    }

    private TrieNode insert(TrieNode node, char[] chars){
       for (char c : chars) {
           if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
           node = node.children.get(c);
        }
        return node;
    }

    // This function search() will also be used for finding words during DFS traversal of the trie
    public TrieNode search(String word) {
      TrieNode current = this.root;
      char[] characters =  word.toCharArray();
        for (char c : characters) {
            if (!current.children.containsKey(c))
               return null;
             else
                 current = current.children.get(c);
         }
       return current;
     }

	public static void main(String[] args) {
	}
}