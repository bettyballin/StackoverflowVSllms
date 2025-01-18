public class ControllerHandler {

    private Model model = new Model();
    private Errors errors = new Errors();

    public String onSubmit(Object command) {
        // validate input
        if (validationOk(command)) {
            // add some data to model
            model.addAttribute("key", "value");
            // or by using @ModelAttribute annotation
            return "/path/to/success";
        } else {
            errors.rejectValue("fieldName", "error code", "default error message");
            return "/path/to/error";
        }
    }

    private boolean validationOk(Object command) {
        // placeholder implementation
        return true;
    }

    public static void main(String[] args) {
    }

}

class Model {
    public void addAttribute(String key, String value) {
        // placeholder
    }
}

class Errors {
    public void rejectValue(String fieldName, String errorCode, String defaultMessage) {
        // placeholder
    }
}