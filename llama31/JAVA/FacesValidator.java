import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import java.util.List;
import java.util.ArrayList;

public class FacesValidator {
    public void validate(FacesContext context, UIComponent component, Object value) {
        // Your validation logic here...
        
        List<FacesMessage> messages = new ArrayList<>();
        
        // Add messages for each field that failed validation
        messages.add(new FacesMessage("Field 1 failed validation"));
        messages.add(new FacesMessage("Field 2 failed validation"));
        
        // Add the messages to the FacesContext
        for (FacesMessage message : messages) {
            context.addMessage(component.getClientId(), message);
        }
        
        // Throw the ValidatorException
        throw new ValidatorException(new FacesMessage("Validation failed"));
    }
    
    public static void main(String[] args) {
    }
}