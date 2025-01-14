import java.lang.String;
public class PricingSystem {
    // Main function to calculate the price based on various factors
    public double getPrice(int itemPrice, int quantity, int clientAge, int hourOfDay) {
        double discount = 0;
        
        // Apply time-based discount if after 6 PM
        if (hourOfDay > 18) {
            discount += calculateDiscount(itemPrice, 5);
        }

        // Apply bulk purchase discount if more than 10 items are purchased
        if (quantity > 10) {
            discount += calculateDiscount(itemPrice * quantity, 5);
        }

        // Apply age-based discount for clients under 18 or over 60
        if (clientAge < 18 || clientAge > 60) {
            discount += calculateDiscount(itemPrice * quantity, 5);
        }

        return Math.max(0, itemPrice * quantity - discount); // Ensure price does not go below zero
    }

    // Helper function to calculate percentage discounts
    private double calculateDiscount(double price, int percent) {
        return price * (percent / 100.0);
    }

	public static void main(String[] args) {
	}
}