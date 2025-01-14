import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<String, TrieNode> children;
    public Effect smallEffect;
    public Effect bigEffect;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public static void main(String[] args) {
    }
}

class Effect {
    // Empty class needed for compilation
}