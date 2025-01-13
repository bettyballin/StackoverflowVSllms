import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

// Assuming @Secured is a custom annotation and not part of a specific security framework like Spring Security
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the @Secured annotation if it's not part of a framework
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Secured {
    String value();
}

@Secured("ROLE_USER")
public class MyAction_2_2 extends ActionSupport {
    // Only accessible by users with ROLE_USER

    public static void main(String[] args) {
    }
}