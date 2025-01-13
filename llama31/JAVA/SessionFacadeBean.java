// SessionFacade.java
public interface SessionFacade {
    public void performBusinessLogic();
}

// SessionFacadeBean.java
import javax.ejb.EJB;

public class SessionFacadeBean implements SessionFacade {
    @EJB
    private BusinessLogicBean businessLogicBean;
    
    public void performBusinessLogic() {
        businessLogicBean.performComplexBusinessLogic();
    }
}

// BusinessLogicBean.java
public class BusinessLogicBean {
    public void performComplexBusinessLogic() {
        // complex business logic implementation
        System.out.println("Performing complex business logic...");
    }

    public static void main(String[] args) {
        BusinessLogicBean businessLogicBean = new BusinessLogicBean();
        SessionFacadeBean sessionFacadeBean = new SessionFacadeBean();
        sessionFacadeBean.businessLogicBean = businessLogicBean;
        sessionFacadeBean.performBusinessLogic();
    }
}