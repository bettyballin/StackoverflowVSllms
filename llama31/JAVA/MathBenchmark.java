import java.lang.String;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class MathBenchmark {
    private double[] array;

    @Setup
    public void setup() {
        array = new double[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public double mathOperations() {
        double sum = 0;
        for (double d : array) {
            sum += Math.sqrt(d) * Math.sin(d);
        }
        return sum;
    }

    public static void main(String[] args) {
        org.openjdk.jmh.Main.main(args);
    }
}