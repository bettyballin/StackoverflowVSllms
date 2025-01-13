/*
 * Decompiled with CFR 0.152.
 */
public class Header {
    public int version;
    public byte type;
    public int beginOfData;
    public byte[] id;

    public Header(int n, byte by, int n2, byte[] byArray) {
        this.version = n;
        this.type = by;
        this.beginOfData = n2;
        this.id = byArray;
    }

    public static void main(String[] stringArray) {
    }
}
