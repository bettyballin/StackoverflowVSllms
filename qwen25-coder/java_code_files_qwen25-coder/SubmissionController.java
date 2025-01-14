public class SubmissionController {

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("formObject") MyForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formView";
        }

        // Add data to model after successful validation
        model.addAttribute("key1", "value1");
        model.addAttribute("key2", "value2");

        return "successView";
    }

    public static void main(String[] args) {
    }
}

@interface PostMapping {
    String value();
}

@interface Valid {
}

@interface ModelAttribute {
    String value();
}

class MyForm {
    // Empty class
}

interface BindingResult {
    boolean hasErrors();
}

class Model {
    public void addAttribute(String key, String value) {
    }
}