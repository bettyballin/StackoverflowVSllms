public class CalculationTest {

    public static void main(String[] args) {
        String[][] testData = {
            {"5", "10", "15"},
            // More test cases as needed
        };
        CalculationTest test = new CalculationTest();
        for (String[] data : testData) {
            test.calculateSum(data[0], data[1], data[2]);
        }
    }

    public void calculateSum(String inputA, String inputB, String expectedResult) {
        assert(expectedResult.equals(add(inputA, inputB))) : "Test failed for inputs: " + inputA + ", " + inputB;
    }

    private String add(String a, String b){
        return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
    }

}