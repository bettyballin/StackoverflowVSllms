/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

class PatriciaTrieNode {
    private String key;
    private Object value;
    private Map<Character, PatriciaTrieNode> children;

    public PatriciaTrieNode(String string, Object object) {
        this.key = string;
        this.value = object;
        this.children = new HashMap<Character, PatriciaTrieNode>();
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object object) {
        this.value = object;
    }

    public Map<Character, PatriciaTrieNode> getChildren() {
        return this.children;
    }
}
