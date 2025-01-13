/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

private static class Trie.Node {
    private String value;
    private Map<Character, Trie.Node> children = new HashMap<Character, Trie.Node>();

    private Trie.Node() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    public Map<Character, Trie.Node> getChildren() {
        return this.children;
    }
}
