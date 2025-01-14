import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// Mock annotations and classes to allow compilation without external dependencies
@interface GetMapping {
    String value();
}

@interface Controller {}

class ModelAndView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public void addObject(String attributeName, Object attributeValue) {
        model.put(attributeName, attributeValue);
    }

    // Optional: getters for viewName and model if needed
    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}

@Controller
public class YourController {

    @GetMapping("/your-endpoint")
    public ModelAndView yourMethod() {
        List<Object> results = new ArrayList<>(); // initialize your list of objects
        Map<String, String> names = new HashMap<>(); // initialize your hashmap with uglyDisplayName as key

        ModelAndView modelAndView = new ModelAndView("yourViewName");
        modelAndView.addObject("results", results);
        modelAndView.addObject("names", names); // assuming "names" is the intended name here
        return modelAndView;
    }
}