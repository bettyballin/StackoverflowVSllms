import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorParameterizedTests {
    @ParameterizedTest(name = "test case #{index}: inputs are {0}, {1} and {2}")
    @CsvSource({"5, 3, 8", "6, 4, 10", "-1, -9, -10"})
    public void testAdd(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.add(a, b));
    }

    public static void main(String[] args) {
    }
}