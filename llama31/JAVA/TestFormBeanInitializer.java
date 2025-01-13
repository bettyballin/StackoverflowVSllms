import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import java.util.Map;

// Assuming TestFormBean is a simple class with the mentioned methods
class TestFormBean {
    private String testMode;
    private String testType;

    public String getTestMode() {
        return testMode;
    }

    public void setTestMode(String testMode) {
        this.testMode = testMode;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}

public class TestFormBeanInitializer {
    public void initTestFormBean(FacesContext facesContext) {
        // Get the session bean
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        TestFormBean testFormBean = (TestFormBean) sessionMap.get("testFormBean");

        // Initialize the bean with the desired parameters
        if (testFormBean == null) {
            testFormBean = new TestFormBean();
            sessionMap.put("testFormBean", testFormBean);
        }

        // Set the desired parameters on the bean
        testFormBean.setTestMode("full"); // or "filtered"
        testFormBean.setTestType("testA"); // or "testB"
    }

    public static void main(String[] args) {
        // For demonstration purposes. Actual usage should be within a JSF context.
        FacesContext facesContext = null; // This should be obtained from your JSF context
        TestFormBeanInitializer initializer = new TestFormBeanInitializer();
        // initializer.initTestFormBean(facesContext); // Uncomment when facesContext is properly set
    }
}