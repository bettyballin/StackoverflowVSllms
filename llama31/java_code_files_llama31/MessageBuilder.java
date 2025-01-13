/*
 * Decompiled with CFR 0.152.
 */
public class MessageBuilder {
    public static void main(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        stringBuilder.append("\u001e");
        stringBuilder.append("World");
        stringBuilder.append("\u0003");
        String string = stringBuilder.toString();
        System.out.println(string);
    }
}
