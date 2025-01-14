// Annotation definitions
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Controller { }

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface GetMapping {
    String value() default "";
}

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface PostMapping {
    String value() default "";
}

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Valid { }

// Model class
class Model {
    public void addAttribute(String attributeName, Object attributeValue) {
        // Do nothing
    }
}

// BindingResult class
class BindingResult {
    public boolean hasErrors() {
        return false;
    }
}

// Parent class
class Parent {
    // Assuming empty class
}

// ParentController class
@Controller
public class ParentController {

    @GetMapping("/parent")
    public String showForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "childform";
    }

    @PostMapping("/parent")
    public String submitForm(@Valid Parent parent, BindingResult result) {
        if (result.hasErrors()) {
            return "childform"; // Return to form on error
        }
        // Process valid parent object
        return "success";
    }

    public static void main(String[] args) {
    }
}