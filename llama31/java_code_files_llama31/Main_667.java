/*
 * Decompiled with CFR 0.152.
 */
public class Main_667 {
    public static void main(String[] stringArray) {
        String string = "http://example.com/path with spaces";
        String string2 = string.replace(" ", "%20");
        System.out.println(string2);
    }
}
