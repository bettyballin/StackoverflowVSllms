import com.paypal.core.api.payments.*;
import com.paypal.core.api.payments.refund.Refund;
import com.paypal.core.api.payments.refund.RefundRequest;

public class Main_148 {
    public static void main(String[] args) {
        // Assuming you have a valid OAuth token and a payment ID
        String paymentId = "PAY-123456789";
        String oauthToken = "your_oauth_token";

        // Create a refund request
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setAmount(new Amount("USD", "10.00")); // refund amount
        refundRequest.setReason("Refund reason"); // refund reason (optional)

        // Create a refund object
        Refund refund = new Refund();
        refund.setRefundRequest(refundRequest);

        // Set up the API context
        APIContext apiContext = new APIContext(oauthToken);

        // Refund the payment
        try {
            Payment payment = Payment.get(apiContext, paymentId);
            payment.refund(apiContext, refund);
            System.out.println("Refund successful");
        } catch (PayPalRESTException e) {
            System.out.println("Error refunding payment: " + e.getMessage());
        }
    }
}