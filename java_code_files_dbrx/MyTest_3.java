import java.lang.String;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyTest_3 {
    private final int input;
    private final int expectedOutput;

    public MyTest_3(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 4},
                {3, 9},
                {10, 100}
        });
    }

    @Test
    public void testFunction() {
        assertEquals(expectedOutput, f(input));
    }

    private int f(int n) {
        return n * n;
    }

    public static void main(String[] args) {
    }
}