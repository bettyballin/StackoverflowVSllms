import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.gui.HeaderPanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestPlan;

public class JMeterTest {
    public static void main(String[] args) {
        // Create a new JMeter test plan
        TestPlan testPlan = new TestPlan("My Test Plan");

        // Create an HTTP sampler
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setMethod("GET");
        httpSampler.setPath("/yourpage");
        httpSampler.setDomain("example.com");
        httpSampler.setPort(80);

        // Create a header manager
        HeaderManager headerManager = new HeaderManager();
        headerManager.addHeader(new Header("Accept", "text/html"));
        httpSampler.setHeaderManager(headerManager);

        // Create a loop controller
        LoopController loopController = new LoopController();
        loopController.setLoops(1);

        // Add the HTTP sampler to the loop controller
        loopController.addTestElement(httpSampler);

        // Add the loop controller to the test plan
        testPlan.addTestElement(loopController);

        // Run the test plan
        StandardJMeterEngine jMeterEngine = new StandardJMeterEngine();
        jMeterEngine.configure(testPlan);
        jMeterEngine.run();

        // Get the sample result
        SampleResult sampleResult = httpSampler.sample();

        // Print the response code and success/failure
        System.out.println("Response Code: " + sampleResult.getResponseCode());
        System.out.println("Success: " + sampleResult.isSuccessful());
    }
}