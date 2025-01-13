import javax.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Validated
public class ProfileController {
    
    @GetMapping("/profile/{id}")
    public ModelAndView viewProfile(@PathVariable @Min(1) Long id) {
        // Assuming you have a service or DAO to load user profile from database
        // For demonstration purposes, it's left as a comment
        UserProfile userProfile = null; // load from database
        
        if (userProfile == null) {
            throw new RuntimeException("User profile not found");
        }
        
        // Create a ModelAndView object
        ModelAndView modelAndView = new ModelAndView("profile"); // Assuming "profile" is the view name
        
        // Add userProfile to model
        modelAndView.addObject("userProfile", userProfile);
        
        return modelAndView;
    }
}