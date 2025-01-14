import java.util.concurrent.TimeUnit;

@interface BenchmarkMode {
    Mode[] value();
}

enum Mode {
    AverageTime
}

@interface OutputTimeUnit {
    TimeUnit value();
}

@interface Warmup {
    int iterations();
    int time();
    TimeUnit timeUnit();
}

@interface Measurement {
    int iterations();
    int time();
    TimeUnit timeUnit();
}

@interface Benchmark {
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class PerformanceTestWithJMH {

    @Benchmark
    public void testYourFunction() {
        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
    }

    // To run this benchmark, you need to add JMH dependencies and use JMH command-line or IDE plugins

    public static void main(String[] args) {
    }
}