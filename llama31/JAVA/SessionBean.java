import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SessionBean {
    // Inject the ADF business component
    @EJB
    private MyADFBC myADFBC;

    public void myMethod() {
        myADFBC.myMethod();
    }

    public static void main(String[] args) {
        // Although not typically used in EJBs, this will not prevent compilation
    }
}