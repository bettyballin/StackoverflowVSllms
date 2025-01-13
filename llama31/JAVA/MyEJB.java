import java.lang.String;
import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;

@Stateless
public class MyEJB {
    @RolesAllowed("Internal")
    public void myMethod() {
        // ...
    }

    public static void main(String[] args) {
    }
}