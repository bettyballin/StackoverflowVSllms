import java.lang.String;

@Controller
public class MyController_1 {

    @ModelAttribute("myCommand")
    public MyCommand populateForm() {
        MyCommand cmd = new MyCommand();
        cmd.setBudget(12345); // Unformatted value
        return cmd;
    }

    @RequestMapping("/myForm")
    public String showForm(Model model) {
        return "myForm";
    }

    public static void main(String[] args) {
    }
}

// Define the annotations
@interface Controller {
}

@interface ModelAttribute {
    String value();
}

@interface RequestMapping {
    String value();
}

// Define Model interface
interface Model {
    // methods can be empty
}

// Define MyCommand class
class MyCommand {
    private int budget;

    public void setBudget(int budget) {
        this.budget = budget;
    }
}