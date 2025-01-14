import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class EditPersonController extends SimpleFormController {

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        super.initBinder(request, binder);
        binder.registerCustomEditor(SSN.class, "person.ssn", new SsnEditor());
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        // Handle the submission actions if needed
    }

    @ExceptionHandler(InvalidSsnException.class)
    public ModelAndView handleInvalidSsn(InvalidSsnException ex, HttpServletRequest request) {
        BindException errors = (BindException) request.getAttribute(BindException.class.getName());
        if (errors != null) {
            errors.rejectValue("person.ssn", ex.getErrorCode(), ex.getMessage());
        }
        return showForm(request, errors, getFormView());
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}

// Stub classes to make the code executable
class SSN {
    // Implementation details
}

class SsnEditor extends java.beans.PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new SSN()); // Simplified conversion
    }
}

class InvalidSsnException extends Exception {
    public String getErrorCode() {
        return "invalid_ssn";
    }

    @Override
    public String getMessage() {
        return "Invalid SSN provided.";
    }
}