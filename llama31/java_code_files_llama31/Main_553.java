/*
 * Decompiled with CFR 0.152.
 */
public class Main_553 {
    public static void main(String[] stringArray) {
        String string = "This is a test string.\nIt has multiple lines.\r\nAnd different types of line breaks.";
        string = string.replaceAll("\\r?\\n", "<br/>");
        System.out.println(string);
    }
}
