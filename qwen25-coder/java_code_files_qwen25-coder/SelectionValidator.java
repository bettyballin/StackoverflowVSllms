import java.util.List;

public class SelectionValidator {
    public void validateSelection(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean isValid = false;
        List<SelectItem> validItems = getValidOptions();
        
        for (SelectItem item : validItems) {
            if (item.getValue().equals(value)) {
                isValid = true;
                break;
            }
        }
    
        if (!isValid) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid selection", null));
        }
    }
    
    public List<SelectItem> getValidOptions() {
        return null;
    }

    public static void main(String[] args) {
    }
}

class FacesContext {
    // Stub class
}

class UIComponent {
    // Stub class
}

class ValidatorException extends Exception {
    public ValidatorException(FacesMessage message) {
        super(message.getSummary());
    }
}

class FacesMessage {
    public static final int SEVERITY_ERROR = 1;

    private int severity;
    private String summary;
    private String detail;

    public FacesMessage(int severity, String summary, String detail) {
        this.severity = severity;
        this.summary = summary;
        this.detail = detail;
    }

    public String getSummary() {
        return summary;
    }
}

class SelectItem {
    public Object getValue() {
        return null;
    }
}