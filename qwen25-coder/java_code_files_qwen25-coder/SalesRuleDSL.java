import java.lang.String;
// This example illustrates a simple Domain Specific Language for defining rules in a sales system

public class SalesRuleDSL {
    private boolean isApplicable = false;
    private double discountRate;

    public SalesRuleDSL ifCustomerIsValued() {
        this.isApplicable = true;
        return this;
    }

    public SalesRuleDSL thenApplyDiscount(double rate) {
        this.discountRate = rate;
        return this;
    }

    public boolean isApplicable() {
        return isApplicable;
    }

    public double getDiscountRate() {
        return discountRate;
    }

	public static void main(String[] args) {
	}
}