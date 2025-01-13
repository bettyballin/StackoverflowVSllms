/*
 * Decompiled with CFR 0.152.
 */
public class UnsignedCharArrayHandler {
    byte[] unsignedCharArray = new byte[]{-1, -2, -3};
    int unsignedChar = this.unsignedCharArray[0] & 0xFF;

    public static void main(String[] stringArray) {
        UnsignedCharArrayHandler unsignedCharArrayHandler = new UnsignedCharArrayHandler();
        System.out.println(unsignedCharArrayHandler.unsignedChar);
    }
}
