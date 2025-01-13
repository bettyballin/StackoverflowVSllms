/*
 * Decompiled with CFR 0.152.
 */
public class Hashtable {
    private Entry[] table;
    private int size;
    private int threshold;

    public Hashtable(int n) {
        this.table = new Entry[n];
        this.size = 0;
        this.threshold = (int)((double)n * 0.75);
    }

    public void put(Object object, Object object2) {
        if (this.size >= this.threshold) {
            this.resize();
        }
    }

    private void resize() {
        int n = this.table.length * 2;
        Entry[] entryArray = new Entry[n];
        for (Entry entry : this.table) {
            if (entry == null) continue;
            int n2 = entry.key.hashCode() % n;
            entryArray[n2] = entry;
        }
        this.table = entryArray;
        this.threshold = (int)((double)n * 0.75);
    }

    public static void main(String[] stringArray) {
        Hashtable hashtable = new Hashtable(10);
    }

    private static class Entry {
        Object key;
        Object value;

        public Entry(Object object, Object object2) {
            this.key = object;
            this.value = object2;
        }
    }
}
