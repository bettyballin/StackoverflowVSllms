import java.lang.String;
import java.util.List;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;

public class CustomValidator_3_3 {
    public void validate(FacesContext context, UIComponent component, Object value) {
        // Your validation logic here...

        List<FacesMessage> messages = new ArrayList<>();

        // Add messages for each field that failed validation
        messages.add(new FacesMessage("Field 1 failed validation"));
        messages.add(new FacesMessage("Field 2 failed validation"));

        // Throw the custom ValidatorException
        throw new ValidatorException(messages);
    }
    public static void main(String[] args) {
    }
}