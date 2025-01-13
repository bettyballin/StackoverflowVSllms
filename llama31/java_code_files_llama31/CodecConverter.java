/*
 * Decompiled with CFR 0.152.
 */
public class CodecConverter {
    public static void main(String[] stringArray) {
    }

    public static interface Decoder<A, B> {
        public B decode(A var1);
    }

    public static interface Encoder<A, B> {
        public A encode(B var1);
    }
}
