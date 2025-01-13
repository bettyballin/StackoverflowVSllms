import java.lang.String;
public class PricingCalculator {
    public int getPrice(int itemPrice, int quantity, int clientAge, int hourOfDay) {
        int discount = 0;

        if (hourOfDay > 18) {
            discount += calculateDiscount(5, itemPrice);
        }

        if (quantity > 10) {
            discount += calculateDiscount(5, itemPrice);
        }

        if (clientAge > 60 || clientAge < 18) {
            discount += calculateDiscount(5, itemPrice);
        }

        return itemPrice - discount;
    }

    private int calculateDiscount(int percentage, int baseValue) {
        return (int) (baseValue * (percentage / 100.0));
    }

	public static void main(String[] args) {
	}
}