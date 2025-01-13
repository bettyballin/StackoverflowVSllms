/*
 * Decompiled with CFR 0.152.
 */
public class EnumMatcher {
    public static void main(String[] stringArray) {
        String string = "C";
        A a = A.valueOf(string);
        if (a == A.C) {
            System.out.println("Match!");
        }
    }

    static enum A {
        B,
        C,
        D;

    }
}
