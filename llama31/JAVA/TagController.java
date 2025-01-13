import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Server-side Java example (using Spring Boot)
@RestController
@RequestMapping("/tags")
public class TagController {
  
  private final TagService tagService;

  public TagController(TagService tagService) {
    this.tagService = tagService;
  }

  @GetMapping("/autocomplete")
  public List<String> autocomplete(@RequestParam("q") String query) {
    // Fetch matching tags from your database or data storage
    List<String> matchingTags = tagService.findMatchingTags(query);
    return matchingTags;
  }

  public static void main(String[] args) {
  }
}

interface TagService {
  List<String> findMatchingTags(String query);
}