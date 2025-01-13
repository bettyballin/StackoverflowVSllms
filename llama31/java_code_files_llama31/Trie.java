/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

class Trie {
    private Node root = new Node();

    public void insert(String string, String string2) {
        Node node = this.root;
        for (char c2 : string.toCharArray()) {
            node = node.getChildren().computeIfAbsent(Character.valueOf(c2), c -> new Node());
        }
        node.setValue(string2);
    }

    public String get(String string) {
        Node node = this.root;
        for (char c : string.toCharArray()) {
            if ((node = node.getChildren().get(Character.valueOf(c))) != null) continue;
            return null;
        }
        return node.getValue();
    }

    private static class Node {
        private String value;
        private Map<Character, Node> children = new HashMap<Character, Node>();

        private Node() {
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String string) {
            this.value = string;
        }

        public Map<Character, Node> getChildren() {
            return this.children;
        }
    }
}
