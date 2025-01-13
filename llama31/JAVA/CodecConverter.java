import java.lang.String;

public class CodecConverter {
    public interface Encoder<A, B> {
        A encode(B b);
    }

    public interface Decoder<A, B> {
        B decode(A a);
    }

    public static void main(String[] args) {
    }
}