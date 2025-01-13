/*
 * Decompiled with CFR 0.152.
 */
public class MultilineStringBuilder {
    public static void main(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This is a multiline string.\n");
        stringBuilder.append("It can span multiple lines.\n");
        stringBuilder.append("No need for concatenation or escaping.\n");
        String string = stringBuilder.toString();
        System.out.println(string);
    }
}
