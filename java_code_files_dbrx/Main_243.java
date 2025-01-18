import tech.tablesaw.api.*;
import java.util.*;

public class Main_243 {
    public static void main(String[] args) {
        // Create a Table with random timing samples
        Table timings = Table.create("Timing Data");
        timings.addColumns(DoubleColumn.create("millisecond", random(1_000_000)));

        // Calculate standard deviation using constant memory
        WelfordsMethod welfordAlgo = new WelfordsMethod();
        for (double sample : timings.doubleColumn("millisecond").asDoubleArray()) {
            welfordAlgo.include(sample);
        }
    }

    public static double[] random(int n) {
        double[] arr = new double[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextDouble();
        }
        return arr;
    }
}

class WelfordsMethod {
    private int count = 0;
    private double mean = 0;
    private double m2 = 0;

    public void include(double x) {
        count++;
        double delta = x - mean;
        mean += delta / count;
        double delta2 = x - mean;
        m2 += delta * delta2;
    }

    public double getVariance() {
        return m2 / (count - 1);
    }

    public double getStandardDeviation() {
        return Math.sqrt(getVariance());
    }
}