import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController_14_14 {
    @Autowired
    private MyService myService;

    @RequestMapping("/myPage")
    public String myPage(Model model) {
        // Retrieve data from the service layer
        List<MyObject> objects = myService.getObjects();
        model.addAttribute("objects", objects);
        return "myPage"; // Return the view name
    }

    public static void main(String[] args) {
    }
}