import java.io.File;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.tools.ExecFileLoader;

public class CoverageReader {
    public static void main(String[] args) throws Exception {
        // Load execution data
        final File executionDatumFile = new File("path/to/coverage.exec");
        ExecFileLoader execFileLoader = new ExecFileLoader();
        execFileLoader.load(executionDatumFile);

        // Read classes that were instrumented by JaCoCo agent
        CoverageBuilder coverageBuilder = new CoverageBuilder();
        Analyzer analyzer = new Analyzer(execFileLoader.getExecutionDataStore(), coverageBuilder);
        analyzer.analyzeAll(new File("path/to/classes"));

        IBundleCoverage bundle = coverageBuilder.getBundle("Your Project Name");
        System.out.println(bundle.getName());
    }
}