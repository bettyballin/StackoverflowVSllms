import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.util.HashMap;

public class StripeCharge {
  public static void main(String[] args) {
    // Set your Stripe secret key
    Stripe.apiKey = "YOUR_STRIPE_SECRET_KEY";

    try {
      // Create a charge
      Charge charge = Charge.create(
        new HashMap<String, Object>() {{
          put("amount", 1000);
          put("currency", "usd");
          put("source", "customer_source");
        }}
      );
      System.out.println(charge);
    } catch (StripeException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}