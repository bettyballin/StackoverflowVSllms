/*
 * Decompiled with CFR 0.152.
 */
public class StringChecker {
    public static void main(String[] stringArray) {
        String string = "Hello";
        if (string instanceof String) {
            String string2 = string;
            System.out.println(string2);
        } else {
            System.out.println("obj is not a String");
        }
    }
}
