import java.lang.String;

public class DoublesUnmarshaller {
    double firstVar;
    double secondVar;

    public DoublesUnmarshaller() {
        double[] returnValues = calculateSomeDoubles();
        unpack(returnValues, firstVar -> this.firstVar = firstVar, secondVar -> this.secondVar = secondVar);
    }

    private double[] calculateSomeDoubles() {
        // You need to implement this method to return an array of doubles
        return new double[2];
    }

    private void unpack(double[] values, java.util.function.Consumer<Double> firstVarConsumer, java.util.function.Consumer<Double> secondVarConsumer) {
        if (values.length != 2) {
            throw new RuntimeException("Array must have exactly two elements");
        }
        firstVarConsumer.accept(values[0]);
        secondVarConsumer.accept(values[1]);
    }

    public static void main(String[] args) {
        new DoublesUnmarshaller();
    }
}