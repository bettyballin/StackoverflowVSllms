import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("person")
public class PersonController {

    @Autowired
    private HttpSession session;

    @PostMapping("/people")
    public String handleFormSubmission(@ModelAttribute Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Store error messages and form data in a temporary storage
            session.setAttribute("errors", bindingResult.getAllErrors());
            session.setAttribute("person", person);
            return "redirect:/people/new?errors=true";
        }
        // Process the form submission (e.g., save the person)
        return "redirect:/people";
    }

    @GetMapping("/people/new")
    public String getNewPersonForm(@RequestParam(required = false) boolean errors, Model model) {
        if (errors) {
            // Retrieve stored error messages and form data
            List<ObjectError> errorList = (List<ObjectError>) session.getAttribute("errors");
            Person person = (Person) session.getAttribute("person");
            model.addAttribute("errors", errorList);
            model.addAttribute("person", person);
        }
        return "new-person-form";
    }

    public static void main(String[] args) {
    }
}