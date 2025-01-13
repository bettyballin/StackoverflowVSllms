import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TravelController {

    @RequestMapping(value="/travel/us/{from}/{to}/{date}/{time}/{departure}/", method=RequestMethod.GET)
    public String getTravelInfo(@PathVariable String from, @PathVariable String to, 
                                @PathVariable String date, @PathVariable String time, 
                                @PathVariable String departure) {
        // Implement your logic here
        return "travel-info"; // This could be a view name or a redirect
    }
}