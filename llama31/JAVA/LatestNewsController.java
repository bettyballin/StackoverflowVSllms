import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/latestNews")
public class LatestNewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getLatestNews(Model model) {
        List<News> newsList = newsService.getLatestNews();
        model.addAttribute("newsList", newsList);
        return "latestNews";
    }

    public static void main(String[] args) {
    }
}