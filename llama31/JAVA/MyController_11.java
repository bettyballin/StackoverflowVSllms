import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

class Foo {}

@Controller
public class MyController_11_11 {
    @GetMapping("/myPage")
    public String myPage(HttpServletRequest request) {
        Foo foo = new Foo();
        request.setAttribute("foo", foo);
        return "myPage";
    }

    public static void main(String[] args) {}
}