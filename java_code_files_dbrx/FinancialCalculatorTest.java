import org.junit.*;
import static org.junit.Assert.*;
import com.example.app.FinancialCalculator;

public class FinancialCalculatorTest {
    @Test
    public void testCalculateInterest() {
        assertEquals(10, new FinancialCalculator().calculateInterestWithFixedRate(1000, 5), 0.0);
    }

    public static void main(String[] args) {
    }
}