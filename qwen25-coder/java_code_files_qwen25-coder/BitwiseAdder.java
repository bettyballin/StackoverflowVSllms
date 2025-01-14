import java.lang.String;
public class BitwiseAdder {
    public int add(int a, int b) {
        while (b != 0) {
            // Calculate carry
            int carry = a & b;
            
            // Sum without carry
            a = a ^ b;
            
            // Shift carry to the left
            b = carry << 1;
        }
        return a;
    }
    public static void main(String[] args) {
    }
}