import java.lang.String;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    // Example method to be tested
    public int f(int input) {
        return input * input; // Just an example function
    }

    @ParameterizedTest
    @CsvSource({
        "2, 4",
        "3, 9",
        "10, 100"
    })
    void testF(int input, int expectedOutput) {
        assertEquals(expectedOutput, f(input));
    }

    public static void main(String[] args) {
    }
}