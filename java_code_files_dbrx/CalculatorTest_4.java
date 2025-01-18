public class CalculatorTest {

    @Test
    public void checkValues_validData() {
        CalculatorParameters params = userDataBuilder().build();
        // ... initialize calculator and calculate expected values

        assertAll(() -> assertEquals(expectedValue1, calculator.calculateValueAtYearN(params, year)));
        // Other comparisons if applicable
    }

    // Stub methods and classes to make the code executable
    private CalculatorParametersBuilder userDataBuilder() {
        return new CalculatorParametersBuilder();
    }

    private class CalculatorParametersBuilder {
        public CalculatorParameters build() {
            return new CalculatorParameters();
        }
    }

    private class CalculatorParameters {
        // Parameters for the calculator
    }

    private Calculator calculator = new Calculator();

    private class Calculator {
        public Object calculateValueAtYearN(CalculatorParameters params, int year) {
            // Calculation logic goes here
            return null;
        }
    }

    private Object expectedValue1 = null; // Replace with actual expected value
    private int year = 0; // Replace with the actual year

    // Stubs to replace JUnit functionalities for compilation
    private @interface Test {}

    private void assertAll(Runnable... executables) {
        for (Runnable executable : executables) {
            executable.run();
        }
    }

    private void assertEquals(Object expected, Object actual) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
    }
}