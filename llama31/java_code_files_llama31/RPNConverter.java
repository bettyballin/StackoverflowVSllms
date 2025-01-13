/*
 * Decompiled with CFR 0.152.
 */
public class RPNConverter {
    public static void main(String[] stringArray) {
        String string = "3 4 + 2 *";
        String string2 = RPNToInfix.rpnToInfix(string);
        System.out.println(string2);
    }
}
