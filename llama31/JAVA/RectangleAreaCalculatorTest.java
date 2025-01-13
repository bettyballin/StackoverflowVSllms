import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RectangleAreaCalculatorTest {
    @Test
    public void testPositiveWidthAndHeight() {
        RectangleAreaCalculator calculator = new RectangleAreaCalculator();
        int width = 5;
        int height = 3;
        int expectedArea = 15;
        assertEquals(expectedArea, calculator.calculateArea(width, height));
    }

    @Test
    public void testNegativeWidth() {
        RectangleAreaCalculator calculator = new RectangleAreaCalculator();
        int width = -5;
        int height = 3;
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateArea(width, height));
    }

    @Test
    public void testNegativeHeight() {
        RectangleAreaCalculator calculator = new RectangleAreaCalculator();
        int width = 5;
        int height = -3;
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateArea(width, height));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("RectangleAreaCalculatorTest");
    }
}

class RectangleAreaCalculator {
    public int calculateArea(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be non-negative");
        }
        return width * height;
    }
}