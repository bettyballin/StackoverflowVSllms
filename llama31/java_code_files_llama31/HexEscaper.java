/*
 * Decompiled with CFR 0.152.
 */
public class HexEscaper {
    public static void main(String[] stringArray) {
        String string = "79827349837493827498";
        Object object = "";
        for (int i = 0; i < string.length(); i += 2) {
            object = (String)object + "\\" + string.substring(i, i + 2);
        }
        System.out.println((String)object);
    }
}
