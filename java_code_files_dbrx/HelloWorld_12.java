// Minimal stub for ModelAndView to make the code executable
class ModelAndView {
    public void setViewName(String viewName) {
        // Implementation can be added later
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello"); // will load the file in /WEB-INF/jsp named ‘hello.jsp’ based on our prefix and suffix
    }
}