import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController_4_4 {
    @RequestMapping("/info.xhtml")
    public String handleInfoRequest() {
        return "info"; // this will be transformed into /WEB-INF/output/info.jsp
    }

    public static void main(String[] args) {
    }
}