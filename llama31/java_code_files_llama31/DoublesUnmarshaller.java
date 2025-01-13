/*
 * Decompiled with CFR 0.152.
 */
import java.util.function.Consumer;

public class DoublesUnmarshaller {
    double firstVar;
    double secondVar;

    public DoublesUnmarshaller() {
        double[] dArray = this.calculateSomeDoubles();
        this.unpack(dArray, d -> {
            this.firstVar = d;
        }, d -> {
            this.secondVar = d;
        });
    }

    private double[] calculateSomeDoubles() {
        return new double[2];
    }

    private void unpack(double[] dArray, Consumer<Double> consumer, Consumer<Double> consumer2) {
        if (dArray.length != 2) {
            throw new RuntimeException("Array must have exactly two elements");
        }
        consumer.accept(dArray[0]);
        consumer2.accept(dArray[1]);
    }

    public static void main(String[] stringArray) {
        new DoublesUnmarshaller();
    }
}
