class Calculator_7 {
    // Static method
    public static int add(int a, int b) {
        return a + b;
    }

    // Instance method
    public int multiply(int a, int b) {
        return a * b;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Using static method
        int sum = Calculator_7.add(5, 3); // No need to instantiate the class

        // Using instance method
        Calculator_7 calc = new Calculator_7();
        int product = calc.multiply(4, 2); // Requires an instance of the class

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}