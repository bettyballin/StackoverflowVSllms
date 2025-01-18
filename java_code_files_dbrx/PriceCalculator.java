import java.lang.String;
public class PriceCalculator {
    public int calculatePrice(int itemPrice, int quantity, int clientAge, int hourOfDay) {
        double discount = 0;
        if (hourOfDay > 18) {
            // Calculate 5% of the price (for each rule that applies).
            discount += this.calculateDiscount(itemPrice, .05);
        }
        if (quantity >= 10) {
            discount += this.calculateDiscount(itemPrice,.05);
        }
        if (clientAge < 18 || clientAge > 60) {
            discount += this.calculateDiscount(itemPrice,.05);
        }
        // Adjusted price is item's original cost subtracting the calculated discount,
        return Math.max((int)(itemPrice - discount), 0);
    }

    private int calculateDiscount(int itemPrice, double percent) {
        return (int)Math.round(itemPrice * percent / 100);
    }

	public static void main(String[] args) {
	}
}