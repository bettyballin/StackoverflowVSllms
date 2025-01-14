import java.lang.String;
public class FactorVerifier {
    // Example of an NP problem: Given a large number N and you need to verify if a given number K is its factor.
    public boolean verifyFactor(int N, int K) {
        return N % K == 0;
    }
    public static void main(String[] args) {
    }
}