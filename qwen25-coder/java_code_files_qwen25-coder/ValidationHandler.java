import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

public class ValidationHandler {
    public String update() {
        try {
            // Your updating logic here
            return "updated";
        } catch (ValidationException e) {
            FacesContext.getCurrentInstance().getExternalContext().getResponse()
                .setHeader("X-Validation-Failed", "true");
            return null;
        }
    }

    public static void main(String[] args) {
    }
}