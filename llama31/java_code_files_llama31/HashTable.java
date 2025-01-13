/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

class HashTable {
    HashMap<Integer, Integer> indexValueMap = new HashMap();

    public void put(int n, int n2) {
        this.indexValueMap.put(n, n2);
    }

    public int get(int n) {
        return this.indexValueMap.getOrDefault(n, -1);
    }

    public void remove(int n) {
        this.indexValueMap.remove(n);
    }
}
