/*
 * Decompiled with CFR 0.152.
 */
public class SqlEscaper {
    public static String escapeSql(String string) {
        return string.replaceAll("[^a-zA-Z0-9_]", "?");
    }

    public static void main(String[] stringArray) {
    }
}
