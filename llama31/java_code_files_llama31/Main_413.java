/*
 * Decompiled with CFR 0.152.
 */
public class Main_413 {
    public static void main(String[] stringArray) {
        byte[] byArray = "This is some example data.".getBytes();
        InMemoryFile inMemoryFile = new InMemoryFile(byArray);
        WekaTool wekaTool = new WekaTool();
        wekaTool.readData(inMemoryFile);
    }
}
