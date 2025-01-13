import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

@ManagedBean
public class MyLogin_1_1 {
    @EJB
    private HttpSession session;

    public void myMethod() {
        String sessionVariable = (String) session.getAttribute("mySessionVariable");
        System.out.println(sessionVariable);
    }

    public static void main(String[] args) {
    }
}