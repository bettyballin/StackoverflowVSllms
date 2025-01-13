import java.lang.String;

public class CalculatorUtils {
    // Function
    public int add(int a, int b) {
        return a + b;
    }

    // Procedure
    public void printHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        CalculatorUtils calculator = new CalculatorUtils();
        System.out.println(calculator.add(2, 3));
        calculator.printHello();
    }
}