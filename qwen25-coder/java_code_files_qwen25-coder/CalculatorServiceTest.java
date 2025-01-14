import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorServiceTest {
    // Example of a simple JUnit test case
    @Test
    public void testAdditionService() {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        assertEquals(5, calculatorService.add(2, 3));
    }

    public static void main(String[] args) {
    }
}

interface CalculatorService {
    int add(int a, int b);
}

class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}