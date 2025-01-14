import java.lang.String;

public class HomePageController {
    
    @RequestMapping("/somePage")
    public ModelAndView somePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("yourJsp");
        
        // Retrieve the current user from session or service layer
        User currentUser = getCurrentUser(request); 
    
        modelAndView.addObject("fullName", currentUser.getFullName());
    
        return modelAndView;
    }
    
    private User getCurrentUser(HttpServletRequest request) {
        // For compilation purposes
        return new User();
    }
    
    public static void main(String[] args) {
    }
}

// Definition of necessary classes and interfaces
class User {
    public String getFullName() {
        return "Dummy User";
    }
}

class ModelAndView {
    public ModelAndView(String viewName) {
    }
    public void addObject(String key, Object value) {
    }
}

class HttpServletRequest {
}

@interface RequestMapping {
    String value();
}