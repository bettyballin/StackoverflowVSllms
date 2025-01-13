/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class IndexFabric {
    private List<PatriciaTrie> layers = new ArrayList<PatriciaTrie>();

    public IndexFabric(int n) {
        for (int i = 0; i < n; ++i) {
            this.layers.add(new PatriciaTrie());
        }
    }

    public void insert(String string, Object object) {
        for (int i = 0; i < this.layers.size(); ++i) {
            int n = (i + 1) * 5;
            String string2 = string.substring(0, Math.min(n, string.length()));
            this.layers.get(i).insert(string2, object);
        }
    }

    public static void main(String[] stringArray) {
        IndexFabric indexFabric = new IndexFabric(3);
        indexFabric.insert("hello world", "example value");
    }
}
