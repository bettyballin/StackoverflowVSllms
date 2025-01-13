/*
 * Decompiled with CFR 0.152.
 */
public class DoubleExtractor {
    double[] returnValues = this.calculateSomeDoubles();

    public static void main(String[] stringArray) {
        DoubleExtractor doubleExtractor = new DoubleExtractor();
        double d = doubleExtractor.returnValues[0];
        double d2 = doubleExtractor.returnValues[1];
    }

    double[] calculateSomeDoubles() {
        return new double[]{1.0, 2.0};
    }
}
