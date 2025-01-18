import java.lang.String;

@interface Controller {}

@interface RequestMapping {
    String value();
}

class HttpServletRequest {}

@Controller
public class MyController_3 {
    @RequestMapping("/myPage")
    public String handleRequest(HttpServletRequest request) throws Exception {
        return "header :: body"; // Use '::' to render 2 or more views at once
    }

    public static void main(String[] args) {
    }
}