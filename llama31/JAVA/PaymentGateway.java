import java.lang.String;

// Define the Calculator class
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

public class PaymentGateway {
    public void processPayment(Calculator calculator, int amount) {
        int tax = calculator.add(amount, 10); // 10% tax
        // Process payment with tax
        System.out.println("Payment processed with tax: " + tax);
    }
}

public class PaymentGatewayTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.processPayment(calculator, 100);
        // Verify payment processing result
    }
}