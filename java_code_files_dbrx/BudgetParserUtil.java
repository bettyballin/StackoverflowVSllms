import java.lang.String;
import java.lang.Integer;
import java.math.BigDecimal;

public class BudgetParserUtil {
    public Integer parseBudgetInput(String budgetInput){
        return new BigDecimal(budgetInput.replaceAll(",", "")).intValue();
    }
    public static void main(String[] args) {
    }
}