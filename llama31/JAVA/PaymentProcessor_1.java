import java.lang.String;

public class PaymentProcessor_1_1 {
    public static void main(String[] args) {
        // Using a secure payment gateway, like Stripe or Braintree
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setApiKey("YOUR_API_KEY");

        // Create a payment token, like a Stripe token
        String cardNumber = "1234-5678-9012-3456";
        int expMonth = 12;
        int expYear = 2025;
        String cvc = "123";
        PaymentToken paymentToken = paymentGateway.createPaymentToken(cardNumber, expMonth, expYear, cvc);

        // Use the payment token to charge the customer
        double amount = 10.99;
        Charge charge = paymentGateway.chargeCustomer(paymentToken, amount);
    }
}

// Assuming these classes are defined elsewhere in your codebase
class PaymentGateway {
    private String apiKey;

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public PaymentToken createPaymentToken(String cardNumber, int expMonth, int expYear, String cvc) {
        // Implementation to create a payment token
        return new PaymentToken();
    }

    public Charge chargeCustomer(PaymentToken paymentToken, double amount) {
        // Implementation to charge the customer
        return new Charge();
    }
}

class PaymentToken {}

class Charge {}