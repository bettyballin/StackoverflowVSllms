import java.util.List;
import java.util.ArrayList;

@RestController
public class ImageController_2 {

    @GetMapping("/images")
    public List<Image> getImages(@RequestParam String keyword) {
        // This method should interact with your Oracle database to fetch images based on the keyword.
        // Placeholder for actual implementation using JPA or JDBC.
        return searchImagesByKeyword(keyword);
    }

    private List<Image> searchImagesByKeyword(String keyword) {
        // Implement logic to query images from Oracle DB using Oracle Text.
        // This is a mock method and does not contain actual database interaction code.
        return new ArrayList<>();
    }

    public static void main(String[] args) {
    }
}

class Image {
    // Implement the Image class
}

@interface GetMapping {
    String value();
}

@interface RequestParam {
}

@interface RestController {
}