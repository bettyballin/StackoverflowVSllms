import java.lang.String;
import java.util.concurrent.TimeUnit;

// Minimal annotations to make the code compile
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface State {
    Scope value();
}

enum Scope {
    Benchmark
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Benchmark {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface OutputTimeUnit {
    TimeUnit value();
}

@State(Scope.Benchmark)
public class MathBenchmark {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int doMath() {
        // Simulate some mathematical computations
        return 1 + 2 * 3;
    }

    public static void main(String[] args) {
    }
}