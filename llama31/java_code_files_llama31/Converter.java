/*
 * Decompiled with CFR 0.152.
 */
public class Converter
implements Encoder,
Decoder {
    @Override
    public A encode(B b) {
        return new A();
    }

    @Override
    public B decode(A a) {
        return new B();
    }

    public static void main(String[] stringArray) {
        Converter converter = new Converter();
        A a = new A();
        B b = new B();
        A a2 = converter.encode(b);
        B b2 = converter.decode(a);
    }
}
