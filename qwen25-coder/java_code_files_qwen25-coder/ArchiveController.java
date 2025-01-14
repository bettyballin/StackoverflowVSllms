import java.lang.String;

@Controller
public class ArchiveController {

    @GetMapping("/archive/new")
    public String newArchive(Model model) {
        return "choose_type"; // A view where users choose the archive type
    }

    @PostMapping("/archive/create")
    public String create(@RequestParam("type") String type, Model model) {
        switch (type) {
            case "video":
                model.addAttribute(new Video());
                break;
            case "book":
                model.addAttribute(new Book());
                break;
            case "audio":
                model.addAttribute(new Audio());
                break;
            default:
                // Handle error: unknown archive type
                return "error";
        }
        return "archive_form"; // A form which is dynamically rendered based on the object in the model
    }

    @PostMapping("/archive/save")
    public String save(Archive archive) {
        // Save logic here based on actual subclass type (use instanceof or similar)
        return "redirect:/archive/" + archive.getId();
    }

    public static void main(String[] args) {
    }
}

@interface Controller {
}

@interface GetMapping {
    String value();
}

@interface PostMapping {
    String value();
}

@interface RequestParam {
    String value();
}

interface Model {
    void addAttribute(Object o);
}

class Archive {
    public String getId() {
        return "1";
    }
}

class Video extends Archive {
}

class Book extends Archive {
}

class Audio extends Archive {
}