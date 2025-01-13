import java.lang.String;
import java.lang.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/upcomingEvents")
public class UpcomingEventsController {
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUpcomingEvents(Model model) {
        List<Event> eventsList = eventService.getUpcomingEvents();
        model.addAttribute("eventsList", eventsList);
        return "upcomingEvents";
    }

    public static void main(String[] args) {
    }
}