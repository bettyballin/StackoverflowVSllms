public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Sum: " + calculator.sum);
        System.out.println("Square of Sum: " + calculator.square_sum);
    }

    int a = 5;
    int b = 6;
    int sum = a + b;
    int square_sum = sum * sum;
}