import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DialogController {

    // Server-side handling (example in Java using Spring)
    @RequestMapping("/hide-dialog")
    public String hideDialog(Model model) {
        // Hide dialog on next page render
        model.addAttribute("hideDialog", true);
        return "page";
    }

    public static void main(String[] args) {
    }
}