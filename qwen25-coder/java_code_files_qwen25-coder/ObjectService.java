import java.util.List;

// Repository Interface
public interface SQLObjectRepository {
    List<Object> findByRegionIds(List<Integer> regionIds);
}

// User Class
class User {
    public List<Integer> getRegionIds() {
        // Return some dummy data
        return List.of(1, 2, 3);
    }
}

// Service Class
public class ObjectService {

    private final SQLObjectRepository objectRepository;

    // Constructor to inject repository dependency
    public ObjectService(SQLObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    // Method to get objects a user can access given their regions
    public List<Object> getObjectsByUserRegions(User user) {
        return objectRepository.findByRegionIds(user.getRegionIds());
    }
}

// Example usage in Controller or Front-End
public class WebController {

    private final ObjectService objectService;

    // Constructor to inject service dependency
    public WebController(ObjectService objectService) {
        this.objectService = objectService;
    }

    public List<Object> fetchUserObjects(User user) {
        return objectService.getObjectsByUserRegions(user);
    }

    public static void main(String[] args) {
        // Create a dummy SQLObjectRepository implementation
        SQLObjectRepository repository = new SQLObjectRepository() {
            @Override
            public List<Object> findByRegionIds(List<Integer> regionIds) {
                // Return some dummy data
                return List.of();
            }
        };

        // Create an ObjectService instance
        ObjectService service = new ObjectService(repository);

        // Create a WebController instance
        WebController controller = new WebController(service);

        // Create a User instance
        User user = new User();

        // Fetch user objects
        List<Object> objects = controller.fetchUserObjects(user);

        // Print the result
        System.out.println("Objects: " + objects);
    }
}