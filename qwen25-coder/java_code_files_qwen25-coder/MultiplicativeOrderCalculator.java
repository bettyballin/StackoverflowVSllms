import java.lang.String;
public class MultiplicativeOrderCalculator {

    // Function to perform modular exponentiation
    private static int modExp(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd, multiply base with result
                result = (result * base) % mod;
            }
            exp >>= 1; // Divide the exponent by 2
            base = (base * base) % mod; // Square the base
        }
        return result;
    }

    // Function to calculate the multiplicative order of x modulo y
    public static int findMultiplicativeOrder(int x, int y) {
        if (gcd(x, y) != 1) {
            throw new IllegalArgumentException("x and y must be coprime");
        }
        
        int mOrder = 1;
        while (modExp(x, mOrder, y) != 1) {
            mOrder++;
            // If you want to set a limit, uncomment the following lines:
            // if (mOrder >= someLimit) {
            //     throw new RuntimeException("Multiplicative order not found within limit");
            // }
        }
        return mOrder;
    }

    // Helper function to calculate gcd
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 53;
        System.out.println("The multiplicative order of " + x + " modulo " + y + " is: " + findMultiplicativeOrder(x, y));
    }
}