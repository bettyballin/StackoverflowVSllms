import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MyTest_6_6 {

    private int input;
    private int expectedOutput;

    public MyTest_6(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Object[][] data() {
        return new Object[][] {
            {2, 4},
            {3, 9},
            {10, 100}
        };
    }

    public static int f(int n) {
        return n * n;
    }

    @Test
    public void testF() {
        assertEquals(expectedOutput, f(input));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("MyTest_6");
    }
}