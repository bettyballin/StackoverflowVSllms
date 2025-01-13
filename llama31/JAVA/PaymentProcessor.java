import java.lang.String;

public class PaymentProcessor {
    // Before
    // public void processPayment() {
    //     // 600 lines of code...
    // }

    // After
    public void processPayment() {
        validatePaymentDetails();
        calculatePaymentAmount();
        performPayment();
    }

    private void validatePaymentDetails() {
        // 20 lines of code...
    }

    private void calculatePaymentAmount() {
        // 20 lines of code...
    }

    private void performPayment() {
        // 20 lines of code...
    }

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment();
    }
}