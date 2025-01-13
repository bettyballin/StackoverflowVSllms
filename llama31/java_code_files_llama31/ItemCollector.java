/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class ItemCollector {
    Set<Node> visited = new HashSet<Node>();
    Set<Item> result = new HashSet<Item>();

    public void dfs(Node node) {
        if (node.isItem()) {
            this.result.add((Item)node);
        }
        this.visited.add(node);
        for (Node node2 : node.getChildren()) {
            if (this.visited.contains(node2)) continue;
            this.dfs(node2);
        }
    }

    public static void main(String[] stringArray) {
        ItemCollector itemCollector = new ItemCollector();
        Node node = new Node();
        itemCollector.dfs(node);
    }
}
