import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.validation.Validator;

public class SsnBindingController {
    protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) {
        // super.initBinder(req, binder); // Commented out as there is no superclass to call
        binder.registerCustomEditor(SSN.class, "person.ssn", new SsnEditor());
        binder.setValidator(new SsnValidator());
    }

    public static void main(String[] args) {
    }
}