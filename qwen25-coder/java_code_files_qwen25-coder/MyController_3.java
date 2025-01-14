import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Controller { }

@Retention(RetentionPolicy.RUNTIME)
@interface GetMapping {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface ResponseBody { }

@Controller
public class MyController_3 {

    @GetMapping("/resource")
    public String getView(Model model) {
        // Prepare the data model for the web view
        model.addAttribute("message", "Hello, Web View!");
        return "viewTemplate"; // Return view name
    }

    @GetMapping("/resource")
    @ResponseBody
    public MyDomainObject getResource() {
        // Prepare and return the object for REST clients
        return new MyDomainObject("Hello, API Client!");
    }

    public static void main(String[] args) {
    }
}

class Model {
    public void addAttribute(String key, String value) {
        // Do nothing
    }
}

class MyDomainObject {
    private String message;

    public MyDomainObject(String message) {
        this.message = message;
    }
}