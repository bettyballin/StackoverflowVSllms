import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class MultiFieldValidationException extends ValidatorException {
    private final List<FacesMessage> facesMessages = new ArrayList<>();

    public void addMessage(final FacesMessage message) {
        this.facesMessages.add(message);
    }

    public static void main(String[] args) {
    }
}