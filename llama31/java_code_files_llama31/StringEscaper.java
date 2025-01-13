/*
 * Decompiled with CFR 0.152.
 */
public class StringEscaper {
    public static void main(String[] stringArray) {
        String string = "79827349837493827498";
        String string2 = string.replaceAll("..", "\\\\\\$0");
        System.out.println(string2);
    }
}
