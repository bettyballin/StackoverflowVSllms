/*
 * Decompiled with CFR 0.152.
 */
class InMemoryFile {
    private byte[] data;

    public InMemoryFile(byte[] byArray) {
        this.data = byArray;
    }

    public byte[] getData() {
        return this.data;
    }
}
