/*
 * Decompiled with CFR 0.152.
 */
public class Main_328 {
    public static void main(String[] stringArray) {
        String string = System.getProperty("java.io.tmpdir");
        if (string == null) {
            throw new RuntimeException("java.io.tmpdir property is not set");
        }
        System.out.println(string);
    }
}
