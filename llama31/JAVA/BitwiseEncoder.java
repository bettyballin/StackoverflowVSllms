public class BitwiseEncoder {
    long a;
    long b;
    long c;

    public BitwiseEncoder() {
        b = 1; // initialize b to avoid compile error
        c = 1; // initialize c to avoid compile error
        a = (long) b << 32 | c; // cast b to long before shifting
    }

    public static void main(String[] args) {
        BitwiseEncoder encoder = new BitwiseEncoder();
    }
}