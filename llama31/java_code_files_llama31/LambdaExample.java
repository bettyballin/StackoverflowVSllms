/*
 * Decompiled with CFR 0.152.
 */
public class LambdaExample {
    public static void main(String[] stringArray) {
        StringToInt stringToInt = string -> string.length();
        int n = stringToInt.apply("Hello");
        System.out.println(n);
    }

    static interface StringToInt {
        public int apply(String var1);
    }
}
