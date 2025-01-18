import static org.junit.Assert.assertEquals;
import org.junit.Test;
// Functional Specifications for Calculator
// 1. It should add two numbers.
// 2. It should subtract one number from another.

public class CalculationTest {
  @Test
  public void testAddition() {
    assertEquals(4, new Calc().calc("+", 2, 2));
  }

  @Test
  public void testSubtraction() {
    assertEquals(-1, new Calc().calc("-", 3, 4));
  }
}

class Calc {
    int calc(String operator, int a, int b){
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                throw new IllegalArgumentException();
          }
     }

    public static void main(String[] args) {
    }
}