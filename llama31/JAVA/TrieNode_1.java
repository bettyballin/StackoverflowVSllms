import java.util.Map;
import java.util.HashMap;

class Effect {
    // This class is not defined in the original code, so I'm adding a simple implementation
    private String name;

    public Effect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class TrieNode_1 {
    private Map<String, TrieNode> children;
    private boolean isEndOfSequence;
    private Effect effect;

    public TrieNode() {
        children = new HashMap<>();
    }

    public void addSequence(String sequence, Effect effect) {
        TrieNode current = this;
        for (String move : sequence.split(",")) {
            current = current.children.computeIfAbsent(move, k -> new TrieNode());
        }
        current.isEndOfSequence = true;
        current.effect = effect;
    }

    public Effect getEffect(String sequence) {
        TrieNode current = this;
        for (String move : sequence.split(",")) {
            current = current.children.get(move);
            if (current == null) {
                return null;
            }
        }
        return current.effect;
    }

    public static void main(String[] args) {
        TrieNode trie = new TrieNode();
        Effect effect = new Effect("Sample Effect");
        trie.addSequence("A,B,C", effect);
        System.out.println(trie.getEffect("A,B,C").getName());  // prints: Sample Effect
    }
}