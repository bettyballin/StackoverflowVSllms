import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import java.security.PolicyContext;
import java.security.Principal;
import java.util.Set;

public class Main_684 {
    public static void main(String[] args) {
        // Get the current Subject
        Subject subject = (Subject) PolicyContext.getContext("javax.security.auth.Subject.container");

        // Get the principals (roles) associated with the Subject
        Set<Principal> principals = subject.getPrincipals();

        // Print the principals
        for (Principal principal : principals) {
            System.out.println(principal);
        }
    }
}