import java.util.Map;
import java.math.BigDecimal;

public class PriceDiscountBenefit extends Benefit {
    private Map<Plan, BigDecimal> discountMap;

    public Map<Plan, BigDecimal> getDiscountMap() { return this.discountMap; }
    public void setDiscountMap(Map<Plan, BigDecimal> map) { this.discountMap = map; }

    public static void main(String[] args) {
    }
}

class Benefit {
}

class Plan {
}