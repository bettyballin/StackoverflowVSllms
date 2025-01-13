import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class MultiMessageValidatorException extends ValidatorException {
    private List<FacesMessage> messages;
    
    public MultiMessageValidatorException(List<FacesMessage> messages) {
        this.messages = messages;
    }
    
    public List<FacesMessage> getMessages() {
        return messages;
    }

    public static void main(String[] args) {
    }
}