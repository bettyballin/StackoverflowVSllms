import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;

public class StripeTokenExample {
    public static void main(String[] args) {
        // Initialize Stripe API
        Stripe.apiKey = "YOUR_STRIPE_API_KEY";

        // Create a token from the credit card information
        Map<String, Object> tokenParams = new HashMap<>();
        tokenParams.put("card[number]", "4242424242424242");
        tokenParams.put("card[exp_month]", 12);
        tokenParams.put("card[exp_year]", 2025);
        tokenParams.put("card[cvc]", "123");

        try {
            Token token = Token.create(tokenParams);

            // Store the token ID, not the credit card information
            String tokenId = token.getId();
            System.out.println("Token ID: " + tokenId);
        } catch (StripeException e) {
            System.out.println("Error creating token: " + e.getMessage());
        }
    }
}