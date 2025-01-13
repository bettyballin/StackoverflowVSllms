import java.lang.String;

public class Calculator_2_2 {
    private int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator_2 calculator = new Calculator_2();
        int result = calculator.add(1, 2);
        System.out.println(result);
    }
}