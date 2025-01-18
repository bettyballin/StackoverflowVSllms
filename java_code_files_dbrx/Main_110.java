import java.lang.String;
// Java – Procedural with a for loop, bad code with global variables
public class Main_110 {
    static int result;
    public static void main(String[] args) {
        calculateFactorial(5);
        System.out.println("Result: " + result);
    }

    public static void calculateFactorial(int n){
        for (result = 1; --n > 0; result *= n ); // Incorrect loop condition and mutable global variable usage
    }
}