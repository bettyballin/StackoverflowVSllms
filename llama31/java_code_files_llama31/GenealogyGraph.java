/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class GenealogyGraph {
    private Set<Horse> visited = new HashSet<Horse>();

    public void dfs(Horse horse) {
        if (this.visited.contains(horse)) {
            return;
        }
        this.visited.add(horse);
        for (Horse horse2 : horse.getParents()) {
            this.dfs(horse2);
        }
        this.visited.remove(horse);
    }

    public static void main(String[] stringArray) {
    }
}
