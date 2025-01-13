import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.gui.HeaderPanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.util.JMeterUtils;

public class JMeterTestPlanBuilder {
    public static void main(String[] args) {
        // Create a new test plan
        TestPlan testPlan = new TestPlan("My Test Plan");

        // Add a HTTP request sampler
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setMethod("GET");
        httpSampler.setPath("/my-page");
        testPlan.addSampler(httpSampler);

        // Add a listener to collect results
        Summariser summaryReport = new Summariser();
        ResultCollector resultCollector = new ResultCollector(summaryReport);
        testPlan.addTestElement(resultCollector);

        // Run the test
        StandardJMeterEngine jMeterEngine = new StandardJMeterEngine();
        jMeterEngine.configure(testPlan);
        jMeterEngine.run();
    }
}