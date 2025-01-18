import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;

public class RequiredFieldValidator {

    private boolean isChecked;

    public void validateRequiredInput(FacesContext context, UIComponent component, Object value){
        if (isChecked && (value == null || "".equals(value))) {
            throw new ValidatorException(new FacesMessage("This field is required."));
        }
    }

    public static void main(String[] args) {
    }
}