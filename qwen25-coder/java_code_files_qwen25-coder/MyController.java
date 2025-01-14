import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/getCount")
    public String getCount(Model model) {
        try {
            int count = myService.getCountFromDatabase();
            model.addAttribute("count", count);
        } catch (RuntimeException e) {
            // Handle the exception, log it, and prepare a user-friendly message
            model.addAttribute("error", "Failed to fetch data: " + e.getMessage());
            return "error";
        }
        return "resultView";
    }

    public static void main(String[] args) {
    }
}

class MyService {
    public int getCountFromDatabase() {
        // Dummy implementation
        return 0;
    }
}

class Model {
    public void addAttribute(String key, Object value) {
        // Dummy implementation
    }
}