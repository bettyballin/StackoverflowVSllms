import java.util.Map;
import java.util.HashMap;

public class Example {

    public static class ModelAndView {
        private Object view;
        private Map<String,Object> model = new HashMap<>();

        public ModelAndView(Object view) {
            this.view = view;
        }

        public ModelAndView addAllObjects(Map<String, Object> modelMap) {
            this.model.putAll(modelMap);
            return this;
        }
    }

    public static class RedirectView {
        private String url;

        public RedirectView(String url) {
            this.url = url;
        }
    }

    public ModelAndView exampleMethod() {
        Map<String, Object> model = new HashMap<>();
        model.put("errors", "example error");
        RedirectView view = new RedirectView("login.html");
        return new ModelAndView(view)
            .addAllObjects(model); // Flash attributes should be added here
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.exampleMethod();
    }
}