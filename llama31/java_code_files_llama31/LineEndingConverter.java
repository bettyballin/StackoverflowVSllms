/*
 * Decompiled with CFR 0.152.
 */
public class LineEndingConverter {
    public static void main(String[] stringArray) {
        String string = "Hello\r\nWorld!";
        String string2 = string.replace("\r\n", "\n");
        System.out.println("Unix text: " + string2);
        String string3 = string2.replace("\n", "\r\n");
        System.out.println("Windows text: " + string3);
    }
}
