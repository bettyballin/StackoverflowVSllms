public class BiConverter {
    interface Convertor<A, B> {
        A encode(B b);
        B decode(A a);
    }
    public static void main(String[] args) {
    }
}