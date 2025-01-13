import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class ScalabilityLadderBenchmark {
    @Param({"10", "100", "1000"})
    private int numUsers;

    @Benchmark
    public void testScalability(Blackhole bh) {
        // Simulate numUsers users
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}