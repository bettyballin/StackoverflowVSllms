/*
 * Decompiled with CFR 0.152.
 */
class WekaTool {
    WekaTool() {
    }

    public void readData(InMemoryFile inMemoryFile) {
        byte[] byArray = inMemoryFile.getData();
        System.out.println("Received data of length: " + byArray.length);
    }
}
