/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class StringStore {
    private static final int CHUNK_SIZE = 1000;
    private String[][] chunks;
    private int chunkCount;

    public StringStore(int n) {
        this.chunkCount = (int)Math.ceil((double)n / 1000.0);
        this.chunks = new String[this.chunkCount][];
        for (int i = 0; i < this.chunkCount; ++i) {
            this.chunks[i] = new String[1000];
        }
    }

    public void addString(String string) {
        int n = this.chunkCount - 1;
        int n2 = 999;
        if (this.chunks[n][n2] != null) {
            ++this.chunkCount;
            this.chunks = (String[][])Arrays.copyOf(this.chunks, this.chunkCount);
            this.chunks[n] = new String[1000];
            n2 = 0;
        }
        this.chunks[n][n2] = string;
    }

    public String getString(int n) {
        int n2 = n / 1000;
        int n3 = n % 1000;
        return this.chunks[n2][n3];
    }

    public static void main(String[] stringArray) {
        StringStore stringStore = new StringStore(10);
        stringStore.addString("Hello");
        stringStore.addString("World");
        System.out.println(stringStore.getString(0));
        System.out.println(stringStore.getString(1));
    }
}
