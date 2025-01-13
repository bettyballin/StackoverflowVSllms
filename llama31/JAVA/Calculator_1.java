public class Calculator_1_1 {
    public static void main(String[] args) {
        Calculator_1 calculator = new Calculator_1();
        System.out.println("Sum: " + calculator.sum);
        System.out.println("Square of Sum: " + calculator.square_sum);
    }

    int c = 4;
    int d = 3;
    int sum = c + d;
    int square_sum = sum * sum;
}