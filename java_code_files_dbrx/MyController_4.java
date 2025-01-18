import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController_4 {
    @RequestMapping("/myPage")
    public ModelAndView handleRequest() {
        String header = "header"; // view names
        String body = "body"; 	// for each part
        String footer = "footer";		// of your page.

        return new ModelAndView(header)     // Render the `header` view first
            .addObject("body", body)   // Add the "body" view as an object
            .addObject("footer", footer); // Add the "footer" view as an attribute
    }

	public static void main(String[] args) {
	}
}