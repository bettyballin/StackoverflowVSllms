import java.lang.String;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class ExampleBenchmark {

    private int x = 42;

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 5, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Fork(value = 3, jvmArgs = {"-Xms512M", "-Xmx512M"})
    public int testMethod() {
        return x * 2;
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}