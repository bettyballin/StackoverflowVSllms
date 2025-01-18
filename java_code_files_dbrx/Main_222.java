import java.lang.String;
import tech.tablesaw.api.*;
import java.util.Random;
import static tech.tablesaw.aggregate.AggregateFunctions.*;

public class Main_222 {
    public static void main(String[] args) {
        // Create a Table with random timing samples
        Table timings = Table.create("Timing Data");
        timings.addColumns(DoubleColumn.create("millisecond", random(1_000_000)));

        // Calculate percentiles and mean value using constant memory
        Table result = timings.summarize("millisecond", mean, percentile(50)).apply();
        System.out.println(result.print());
    }

    private static double[] random(int n) {
        double[] data = new double[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextDouble() * 1000.0;
        }
        return data;
    }
}