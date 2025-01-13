/*
 * Decompiled with CFR 0.152.
 */
public class NullNameHandler {
    public static void main(String[] stringArray) {
        String string = null;
        if (string == null) {
            System.out.println("Name is unspecified");
        } else if (string.isEmpty()) {
            System.out.println("Name is empty");
        }
    }
}
