import java.lang.String;
import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Factorial of " + number + " is " + calculateFactorial(number));
        scanner.close();
    }

    static int calculateFactorial(int n) {
        return (n <= 1) ? 1 : n * calculateFactorial(n - 1);
    }
}