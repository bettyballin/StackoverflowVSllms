import java.lang.String;
// Example of a Module: a utility module providing common functionalities
public class UtilityModule {
    public static void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Example of a Component: an independent unit with a specific responsibility
class PaymentComponent {
    private String paymentGateway;

    public PaymentComponent(String gateway) {
        this.paymentGateway = gateway;
    }

    public boolean processPayment(double amount) {
        // Logic to process payment
        UtilityModule.log("Processing payment of $" + amount + " via " + paymentGateway);
        return true; // Simplified success response
    }

	public static void main(String[] args) {
	}
}