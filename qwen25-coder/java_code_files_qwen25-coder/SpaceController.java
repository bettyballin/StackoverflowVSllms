import java.util.List;

@RestController
@RequestMapping("/Entities")
public class SpaceController {

    private SpaceCategoryService spaceCategoryService;

    @GetMapping("/Spaces/SpaceCategories/")
    public List<SpaceCategory> getSpaceCategories() {
        // Logic to retrieve space categories
        return spaceCategoryService.getAllCategories();
    }
}

@RestController
@RequestMapping("/Lookups")
public class LookupController {

    private SpaceCategoryService spaceCategoryService;

    @GetMapping("/SpaceCategories/")
    public List<SpaceCategory> getSpaceCategories() {
        // Logic to retrieve space categories independently
        return spaceCategoryService.getAllCategories();
    }

    public static void main(String[] args) {
        // Application entry point
    }
}

class SpaceCategory {
    // Definition of SpaceCategory class
}

class SpaceCategoryService {
    public List<SpaceCategory> getAllCategories() {
        return null; // Stub implementation
    }
}

@interface RestController {
}

@interface RequestMapping {
    String value();
}

@interface GetMapping {
    String value();
}