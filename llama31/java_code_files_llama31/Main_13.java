/*
 * Decompiled with CFR 0.152.
 */
public class Main_13 {
    public static String sanitize(String string) {
        return string.trim().replaceAll("<.*?>", "");
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_13.sanitize("   Hello, <b>world!</b>   "));
    }
}
