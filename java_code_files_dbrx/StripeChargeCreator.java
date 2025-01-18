import java.util.HashMap;
import java.util.Map;
import com.stripe.Stripe;
import com.stripe.model.Charge;

public class StripeChargeCreator {
    public static void main(String[] args) {
        // Example in Stripe's Java library
        // Use the Test API Key from the Dashboard during testing.
        Stripe.apiKey = "sk_test_1234567890abcdefghijklmnopqrstuv";

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", 100);     // amount in cents
        chargeParams.put("currency", "usd");
        String token = "tok_test_visa";    // A test token generated using Stripe Test Card Numbers
        chargeParams.put("card", token);

        try {
            Charge charge = Charge.create(chargeParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}