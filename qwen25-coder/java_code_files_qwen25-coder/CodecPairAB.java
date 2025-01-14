import java.lang.String;
public class CodecPairAB {
    interface Encoder<A, B> {
        A encode(B b);
    }

    interface Decoder<A, B> {
        B decode(A a);
    }

    public static void main(String[] args) {
    }
}