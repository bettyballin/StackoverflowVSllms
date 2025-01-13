import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import java.util.Set;

public class TestPhaseListener implements PhaseListener {
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        TestFormBean testFormBean = (TestFormBean) facesContext.getExternalContext().getSessionMap().get("testFormBean");
        if (testFormBean == null) {
            testFormBean = new TestFormBean();
            facesContext.getExternalContext().getSessionMap().put("testFormBean", testFormBean);
        }
        // Set the desired parameters on the bean
        testFormBean.setTestMode("full"); // or "filtered"
        testFormBean.setTestType("testA"); // or "testB"
    }

    public void beforePhase(PhaseEvent event) {}

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    public static void main(String[] args) {}
}

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