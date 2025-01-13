/*
 * Decompiled with CFR 0.152.
 */
public class Main_21 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replaceAll("<.*?>", "");
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_21.sanitize("<p>Hello, World!</p>"));
    }
}
