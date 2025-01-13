import java.util.Arrays;

public class DoubleExtractor {
    public static void main(String[] args) {
        DoubleExtractor extractor = new DoubleExtractor();
        double firstVar = extractor.returnValues[0];
        double secondVar = extractor.returnValues[1];
    }

    double[] returnValues = calculateSomeDoubles();

    double[] calculateSomeDoubles() {
        // replace this with your actual calculation
        return new double[]{1.0, 2.0};
    }
}