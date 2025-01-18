import java.util.List;

// Your Action Class
public class ProductVerification extends ActionSupport {
    //... fields, getters and setters ...

    private int countryId;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (getCountryId() == 0) { // Use your field countryId here rather than request.getParameter as it's mapped automatically in Struts
            addFieldError("countryId", "Please select country"); // Spelling corrected to 'select' not 'please-select'.
        }
    }

    private List<Country> countries; // Assume you have Country object for each list item. If not, update accordingly.

    public List<Country> getCountries() {
        return this.countries; // Implement logic to retrieve the list here
    }

    @SkipValidation // Annotation used to skip JSP validation phase and go straight into execution phase.
    public String input() {
        return INPUT;
    }

    public static void main(String[] args) {
    }
}

// Stub definitions to make the code compilable
class ActionSupport {
    public static final String SUCCESS = "success";
    public static final String INPUT = "input";

    public void addFieldError(String fieldName, String errorMessage) {
        // Empty implementation for compilation
    }

    public void validate() {
        // Empty implementation
    }
}

@interface SkipValidation {
}

class Country {
    // Empty implementation
}