/*
 * Decompiled with CFR 0.152.
 */
public class Main_16 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("'", "''");
        return string;
    }

    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        String string2 = Main_16.sanitize(string);
        System.out.println(string2);
    }
}
